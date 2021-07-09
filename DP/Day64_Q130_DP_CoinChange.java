


// Coin Change 

/**
 * Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins.


Example 1:

Input:
n = 4 , m = 3
S[] = {1,2,3}
Output: 4
Explanation: Four Possible ways are:
{1,1,1,1},{1,1,2},{2,2},{1,3}.
Example 2:

Input:
n = 10 , m = 4
S[] ={2,5,3,6}
Output: 5
Explanation: Five Possible ways are:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
and {5,5}.

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which accepts an array S[] its size m and n as input parameter and returns the number of ways to make change for N cents.


Expected Time Complexity: O(m*n).
Expected Auxiliary Space: O(n).


Constraints:
1 <= n,m <= 103


 */

class Solution
{
    public long count(int S[], int N, int W) 
    { 
        long[][] dp = new long[N+1][W+1];
        
        for(int n = 0; n<=N;n++)
        for(int w = 0; w<=W;w++)
            if(w==0) dp[n][w] = 1;
            
        for(int n = 1; n<=N;n++)
        for(int w = 1; w<=W;w++)
            dp[n][w] = (S[n-1]<=w? dp[n][w-S[n-1]]:0) + dp[n-1][w];
        
        return dp[N][W]; 
    } 
}