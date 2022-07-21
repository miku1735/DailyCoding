

//Cheapest Flights Within K Stops


/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation: The graph is shown.
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 

Constraints:

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
 */


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
     {
         int[] cost=new int[n];
         Arrays.fill(cost,Integer.MAX_VALUE);
         cost[src]=0;
         for(int i=0;i<=K;i++)
         {
             int[] temp= Arrays.copyOf(cost,n);
             for(int[] f: flights)
             {
                 int curr=f[0],next=f[1],price=f[2];
                 if(cost[curr]==Integer.MAX_VALUE)
                     continue;
                 temp[next]=Math.min(temp[next],cost[curr]+price);
             }
             cost=temp;
         }
         return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
     }
 }


 class Node{
    int node;
    int weight;
    int pathLength;
    Node(int node, int weight, int pathLength){
        this.node = node;
        this.weight = weight;
        this.pathLength = pathLength;
    }
}
class NodeCompare implements Comparator<Node>{
    public int compare(Node a, Node b){
        return a.weight-b.weight;
    }
}


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        PriorityQueue<Node> q = new PriorityQueue<>(new NodeCompare());
        
        int[][] cost = new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE/2);
        }
        for(int i=0;i<k;i++){
            cost[src][i] = 0;
        }
        
        q.add(new Node(src,0,0));
        
        
        
        while(!q.isEmpty()){
            Node curr = q.poll();

            for(int i=0;i<flights.length;i++){
                if(curr.node == flights[i][0]){
                    if(curr.pathLength <=k && curr.weight+flights[i][2]<cost[flights[i][1]][curr.pathLength]){
                        q.add(new Node(flights[i][1], curr.weight+flights[i][2], curr.pathLength + 1));
                        cost[flights[i][1]][curr.pathLength] = curr.weight+flights[i][2];
                    }
                }
            }
        }

        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=k;i++){
            min = Math.min(min, cost[dst][i]);
        }
        if(min==Integer.MAX_VALUE/2) return -1;
        return min;   
    }
}