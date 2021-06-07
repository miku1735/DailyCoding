




// Min Cost Climbing Stairs




/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
 */


class Solution {
    int totalSum[];
    Solution(){}
    Solution(int size){
        totalSum = new int[size];
        Arrays.fill(totalSum,-1);
    }
    public int findMinCost(int[] cost, int index){
        if(index >= cost.length){
            return 0; 
        }
        int min1=0,min2=0;
        if(this.totalSum[index] !=-1) return this.totalSum[index];
        min1 = findMinCost(cost,index+1);        
        min2 = findMinCost(cost,index+2);
        
        this.totalSum[index] = Math.min(min1,min2) + cost[index] ;
        return this.totalSum[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        Solution s = new Solution(cost.length);
        int v1 = s.findMinCost(cost,0);
        System.out.print(Arrays.toString(s.totalSum));
        return Math.min(s.totalSum[0],s.totalSum[1]);
    }
}