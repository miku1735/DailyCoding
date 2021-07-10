

// Maximize The Cut Segments


/**
 * Given an integer N denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.

Example 1:

Input:
N = 4
x = 2, y = 1, z = 1
Output: 4
Explanation:Total length is 4, and the cut
lengths are 2, 1 and 1.  We can make
maximum 4 segments each of length 1.
Example 2:

Input:
N = 5
x = 5, y = 3, z = 2
Output: 2
Explanation: Here total length is 5, and
the cut lengths are 5, 3 and 2. We can
make two segments of lengths 3 and 2.
Your Task:
You only need to complete the function maximizeTheCuts() that takes n, x, y, z as parameters and returns max number cuts.

Expected Time Complexity : O(N)
Expected Auxiliary Space: O(N)

Constraints
1 <= N, x, y, z <= 104
 */


class Solution
{
    public int maximizeCuts(int W, int x, int y, int z)
    {
        int[] cuts = new int[]{x,y,z};
        int N = 3;
        int[][] dp = new int[N+1][W+1];
        
        for(int n = 0;n<=N;n++)
        for(int w = 0;w<=W;w++){
            if(n==0) dp[n][w] = Integer.MIN_VALUE;
            if(w==0) dp[n][w] = 0;
        }
        
        for(int n = 1;n<=N;n++)
        for(int w = 1;w<=W;w++)
            if(cuts[n-1]<=w)
                dp[n][w] = Math.max(1 + dp[n][w-cuts[n-1]], dp[n-1][w]);
            else
                dp[n][w] = dp[n-1][w];
                
        return dp[N][W]<0?0:dp[N][W];
    }
}