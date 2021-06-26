


// Critical Connections in a Network


/**
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
 */


class Solution {
    int level = 0;
    public void DFS(int node, int parent, boolean[] visited, int[] self, int[] low, List<Integer>[] con, List<List<Integer>> res){
        visited[node] = true;
        self[node] = low[node] = level++;
        
        for(Integer adj : con[node]){
            if(adj==parent) continue;
            if(!visited[adj]){
                DFS(adj,node,visited,self,low,con,res);
                low[node] = Math.min(low[node],low[adj]);
                if(self[node]<low[adj]){
                    List<Integer> col = new ArrayList();
                    col.add(node);
                    col.add(adj);
                    res.add(col);
                }
            }
            else{
                low[node] = Math.min(low[node],self[adj]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> conn) {
        List<List<Integer>> res = new ArrayList();
        int[] self = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        List<Integer>[] con = new ArrayList[n];
        for(int i=0;i<con.length;i++){
            con[i] = new ArrayList();
        }
        for(int i=0;i<conn.size();i++){
            int a = conn.get(i).get(0);
            int b = conn.get(i).get(1);
            con[a].add(b);
            con[b].add(a);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                DFS(i,-1,visited,self,low,con,res);
            }
        }
        return res;
    }
}