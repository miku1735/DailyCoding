



// Strongly Connected Components (Kosaraju's Algo) 


/**
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 

Example 1:

Input:
5 5
1 0
0 2
2 1
0 3
3 4
Output:
3
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph

Your Task:
You don't need to read input or print anything. Your task is to complete the function kosaraju() which takes the number of vertices V and adjacency list of the graph as inputs and returns an integer denoting the number of strongly connected components in the given graph.
 

Expected Time Complexity: O(V+E).
Expected Auxiliary Space: O(V).
 */


class Solution
{
    public void DFS(int N, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        visited[N] = true;
        for(Integer a : adj.get(N)){
            if(!visited[a]){
               DFS(a, visited, adj, stack);
               stack.add(a);
            }
        }
    }
    public void DFS(int N, boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[N] = true;
        for(Integer a : adj.get(N)){
            if(!visited[a]){
               DFS(a, visited, adj);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> reverseADJ(int V, ArrayList<ArrayList<Integer>>adj){
        ArrayList<ArrayList<Integer>> newADJ = new ArrayList();
        for(int i=0;i<V;i++){
            newADJ.add(new ArrayList());
        }
        for(int i=0;i<V;i++){
            for(Integer a : adj.get(i)){
                newADJ.get(a).add(i);
            }
        }
        return newADJ;
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Step1 Find the rank in Stack
        int count = 0;
        Stack<Integer> stack  = new Stack();
        boolean[] visited = new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(!visited[i]){
                DFS(i, visited, adj, stack);
                stack.add(i);
            }
        }
        // Step2 reverse nodes..
        adj = reverseADJ(V,adj);
        Arrays.fill(visited,false);
        // Step3 DFS by Topological sorted rank in Stack
        for(int i=0;i<V;i++)
        {
            int ele = stack.pop();
            if(!visited[ele]){
                DFS(ele, visited, adj);
                count++;
            }
        }
        return count;
    }
}