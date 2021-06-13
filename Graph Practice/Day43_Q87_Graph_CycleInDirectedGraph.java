





// Detect cycle in a directed graph


/**
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:
4 4
0 1
1 2
2 3
3 3
Output: 1
Explanation: 3 -> 3 is a cycle

Your task:
You don’t need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)
 */

class Solution 
{
    boolean cycle = false;
    
    public void DFS(int Node, ArrayList<ArrayList<Integer>> list, int V, boolean[] visited, boolean[] currPath){
        ArrayList<Integer> Edges = list.get(Node);
        for(int i = 0;i<Edges.size();i++){
            int nextNode = Edges.get(i);
            
            if(visited[nextNode] && currPath[nextNode]) cycle = true;
            if(!visited[nextNode]){
                visited[nextNode] = true;
                currPath[nextNode] = true;
                DFS(nextNode, list, V, visited, currPath);
                currPath[nextNode] = false;
            }
        }
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> list)
    {
        boolean[] visited = new boolean[V];
        boolean[] currPath = new boolean[V];
        Arrays.fill(visited, false);
        Arrays.fill(currPath, false);
        for(int i =0;i<V;i++){
            if(!visited[i]){
                visited[i] = true;
                currPath[i] = true;
                DFS(i, list, V, visited, currPath);
                currPath[i] = false;
            }
        }
        return cycle;
    }
}