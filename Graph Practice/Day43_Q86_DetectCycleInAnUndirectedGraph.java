


// Detect cycle in an undirected graph


/**
 * Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Example 1:

Input:   

Output: 1
Explanation: 1->2->3->4->1 is a cycle.
Example 2:

Input: 

Output: 0
Explanation: No cycle in the graph.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not.
 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 

Constraints:
1 ≤ V, E ≤ 105
 */


class Solution
{
    boolean cycle = false;
    
    public void DFS(int Node, ArrayList<ArrayList<Integer>> list, boolean[] visited, int[] parent){
        ArrayList<Integer> Edges = list.get(Node);

        for(int i=0;i<Edges.size();i++){
            int edge = Edges.get(i);
            if(visited[edge] && parent[Node]!=edge) cycle = true;
            if(!visited[edge]){
                visited[edge] = true; parent[edge] = Node;
                DFS(edge, list, visited, parent);
            }
        }
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> list)
    {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                visited[i] = true; parent[i] = i;
                DFS(i, list, visited, parent);
            }
        }
        return cycle;
    }
}