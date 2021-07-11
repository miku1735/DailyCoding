


// Number of Coins


/**
 * Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins. Find the minimum number of coins to make the change. If not possible to make change then return -1.


Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
Output: 2 
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:  
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V*M ≤ 106
All array elements are distinct
 */

class Solution{

	public int minCoins(int coins[], int N, int W) 
	{ 
	    int[][] dp = new int [N+1][W+1];
	    
	    for(int n=0;n<=N;n++)
	    for(int w=0;w<=W;w++){
	        if(n==0) dp[n][w] = Integer.MAX_VALUE/2;
	        if(w==0) dp[n][w] = 0;
	    }
   
	    for(int n=1;n<=N;n++)
	    for(int w=1;w<=W;w++)
	        if(coins[n-1]<=w)
	            dp[n][w] = Math.min(dp[n][w-coins[n-1]]+1, dp[n-1][w]);
	        else
	            dp[n][w] = dp[n-1][w];

	    return dp[N][W]>W?-1:dp[N][W];
	} 
}