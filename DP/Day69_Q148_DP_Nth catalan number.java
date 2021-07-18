


// Nth catalan number


/**
 * Given a number N. The task is to find the Nth catalan number.
The first few Catalan numbers for N = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
Note: Positions start from 0 as shown above.

Example 1:

Input:
N = 5
Output: 42
Example 2:

Input:
N = 4
Output: 14
Your Task:
Complete findCatalan() function that takes n as an argument and returns the Nth Catalan number. The output is printed by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 100
 */

class Solution
{
    //Function to find the nth catalan number.
    public static int findCatalan(int N)
    {
        if(N == 0 || N == 1) return 1;
        
        int[] dp = new int[N+1];
        dp[0] = dp[1] = 1;
        int nthCatalan;
        
        // 5th Catalan no = C0*C4 + C1*C3 + C2*C2 + C3*C1 + C4*C0
        
        for(int n = 2; n<=N; n++){
            nthCatalan = 0;
            for(int i = 0; i<n; i++){
                nthCatalan += dp[i] * dp[n-1-i];
            }
            dp[n] = nthCatalan;
        }
        return dp[N];
    }
}