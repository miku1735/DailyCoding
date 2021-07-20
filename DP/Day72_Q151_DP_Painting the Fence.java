
// Painting the Fence


/**
 * Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. Since answer can be large return it modulo 10^9 + 7.


Example 1:

Input:
N=3,  K=2 
Output: 6
Explanation: We have following possible combinations:
 

Example 2:

Input:
N=2,  K=4
Output: 16

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function countWays() that takes n and k as parameters and returns the number of ways in which the fence can be painted.(modulo 109 + 7)

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N ≤ 105
1 ≤ K ≤ 100
 */

class Solution
{
    long countWays(int n,int k)
    {
        long dp[][] = new long[3][n+1];
        if(n==1) return k;
        int mod = (int)Math.pow(10,9) + 7;
        dp[0][2] = k; // with double
        dp[1][2] = k * (k-1); // without double
        dp[2][2] = dp[0][2] + dp[1][2]; // total
        for(int i=3; i<=n; i++){
            dp[0][i] = (dp[1][i-1])%mod;
            dp[1][i] = ((dp[2][i-1]%mod) * ((k-1)%mod))%mod;
            dp[2][i] = ((dp[0][i]%mod) + (dp[1][i]%mod))%mod;
        }
        
        return dp[2][n];
    }
}