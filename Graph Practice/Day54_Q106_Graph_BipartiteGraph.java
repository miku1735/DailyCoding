




// Bipartite Graph

/**
 * Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
 

Example 1:

Input: 

Output: 1
Explanation: The given graph can be colored 
in two colors so, it is a bipartite graph.
Example 2:

Input:

Output: 0
Explanation: The given graph cannot be colored 
in two colors such that color of adjacent 
vertices differs. 
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isBipartite() which takes V denoting no. of vertices and adj denoting adjacency list of graph and returns a boolean value true if graph is bipartite otherwise returns false.
 

Expected Time Complexity: O(V)
Expected Space Complexity: O(V)
 */

class Solution
{
    boolean ans = true;
    public void DFS(int N,int parentColor, int[] visited, ArrayList<ArrayList<Integer>>adj){
        visited[N] = parentColor==1?2:1;
        
        for(Integer a : adj.get(N)){
            if(visited[a]==0){
                DFS(a,visited[N], visited, adj);
            }
            else{
                if(a!=N && visited[N]==visited[a]){
                   ans = false;
                }
            }
        }
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                DFS(i,1, visited, adj);
            }
        }
        return ans;
    }
}