



// nCr

/**
 * Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.

Example 1:

Input: n = 3, r = 2
Output: 3
Explaination: 3C2 = 3. 

Example 2:

Input: n = 2, r = 4
Output: 0
Explaination: r is greater than n.

Your Task:
You do not need to take input or print anything. Your task is to complete the function nCr() which takes n and r as input parameters and returns nCr modulo 109+7..


Expected Time Complexity: O(n*r)
Expected Auxiliary Space: O(r)


Constraints:
1 ≤ n ≤ 1000
1 ≤ r ≤ 800
 */

class Solution{
    static int nCr(int n, int r)
    {
        if(r>n) return 0;
        if(r==n) return 1;
        int mod = (int)Math.pow(10,9) + 7;
        int[][] dp = new int[n+1][r+1];
        
        for(int i = 0; i<=n; i++)
        for(int j = 0; j<=r; j++){
            if(i==j) dp[i][j] = 1;
            if(j==0) dp[i][j] = 1;
        }
        for(int i = 1; i<=n; i++)
        for(int j = 1; j<i && j<=r; j++){
            dp[i][j] = (dp[i-1][j-1]%mod + dp[i-1][j]%mod)%mod;
        }
        return dp[n][r];
    }
}