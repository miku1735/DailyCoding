


// Minimum time taken by each job to be completed given by a Directed Acyclic Graph


/**
 * Given a Directed Acyclic Graph having V vertices and E edges, where each edge {U, V} represents the Jobs U and V such that Job V can 
 * only be started only after completion of Job U.
 * The task is to determine the minimum time taken by each job to be completed where each Job takes unit time to get completed.
 */


class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> list) 
    {
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            ArrayList<Integer> adj = list.get(i);
            for(int j = 0;j<adj.size();j++){
                inDegree[adj.get(j)]+=1;
            }
        }
        int[] res = new int[V];
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                q.add(i);
                res[i] = 1;
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ArrayList<Integer> adj = list.get(node);
            for(int i = 0;i<adj.size();i++){
                inDegree[adj.get(i)]--;
                res[adj.get(i)] = Math.max(res[adj.get(i)], res[node] + 1);
                if(inDegree[adj.get(i)] == 0){
                    q.add(adj.get(i));
                }
            }
        }
        return res;
    }
}