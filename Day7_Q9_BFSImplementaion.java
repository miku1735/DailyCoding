

// BFS of graph 

/**
    Easy Accuracy: 42.71% Submissions: 90570 Points: 2
    Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
    Note: One can move from node u to node v only if there's an edge from u to v and find the BFS traversal of the graph starting from the 0th vertex, 
    from left to right according to the graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.
 */

 /**
  *Example 1:

    Input:

    Output: 0 1 2 3 4
    Explanation: 
    0 is connected to 1 , 2 , 3.
    2 is connected to 4.
    so starting from 0, it will go to 1 then 2
    then 3.After this 2 to 4, thus bfs will be
    0 1 2 3 4.
*/

/**
 * Example 2:

    Input:

    Output: 0 1 2
    Explanation:
    0 is connected to 1 , 2.
    so starting from 0, it will go to 1 then 2,
    thus bfs will be 0 1 2 3 4. 
*/

/**
  * Your task:
    You don’t need to read input or print anything. Your task is to complete the function bfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as 
    input parameters and returns  a list containing the BFS traversal of the graph starting from the 0th vertex from left to right.
*/

// Expected Time Complexity: O(V + E)
// Expected Auxiliary Space: O(V)

// Constraints:
// 1 ≤ V, E ≤ 104

public class Day7_Q9_BFSImplementaion {
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,Integer> visitedMap = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        queue.add(0);
        visitedMap.put(0,1); // visited root node
        while(!queue.isEmpty()){
            int parent = queue.peek();
            resultList.add(queue.poll());
            for(int i = 0;i< adj.get(parent).size();i++){
                if(!visitedMap.containsKey(adj.get(parent).get(i))){
                    queue.add(adj.get(parent).get(i));
                    visitedMap.put(adj.get(parent).get(i),1);
                }
                
            }
        }
        return resultList;
    }
}
