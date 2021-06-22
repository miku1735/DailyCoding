




// Detect Negative Cycles


/**
 * Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains a negative weight cycle or not.
Note: edges[i] is defined as u, v and weight.
 

Example 1:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,-3}}
Output: 1
Explanation: The graph contains negative weight
cycle as 0->1->2->0 with weight -1,-2,-3,-1.
Example 2:

Input: n = 3, edges = {{0,1,-1},{1,2,-2},
{2,0,3}}
Output: 0
Explanation: The graph does not contain any
negative weight cycle.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function isNegativeWeightCycle() which takes n and edges as input paramater and returns 1 if graph contains negative weight cycle otherwise returns 0.
 

Expected Time Complexity: O(n*m)
Expected Space Compelxity: O(n)
 

Constraints:
1 <= n <= 100
1 <= m <= n*(n-1), where m is the total number of Edges in the directed graph.

 */


class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        
        for(int z=1;z<=n-1;z++){
            boolean isUpdating = true;
            for(int i=0;i<edges.length;i++){
                if(dist[edges[i][0]]!=Integer.MAX_VALUE && dist[edges[i][0]]+edges[i][2] < dist[edges[i][1]]){
                    dist[edges[i][1]] = dist[edges[i][0]]+edges[i][2];
                    isUpdating = false;
                }
            }
            if(isUpdating) break;
        }
        // System.out.print(Arrays.toString(dist));
        for(int i=0;i<edges.length;i++){
                if(dist[edges[i][0]]!=Integer.MAX_VALUE && dist[edges[i][0]]+edges[i][2] < dist[edges[i][1]]){
                    // System.out.print(Arrays.toString(dist));
                    return 1;
                }
            }
        return 0;
    }
}