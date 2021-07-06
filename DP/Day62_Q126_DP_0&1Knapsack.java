



// Zero onr knapsack


/**
 * You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

Example 1:

Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Example 2:

Input:
N = 3
W = 3
values[] = {1,2,3}
weight[] = {4,5,6}
Output: 0
Your Task:
Complete the function knapSack() which takes maximum capacity W, weight array wt[], value array val[], and the number of items n as a parameter and returns the maximum possible value you can get.

Expected Time Complexity: O(N*W).
Expected Auxiliary Space: O(N*W)

Constraints:
1 ≤ N ≤ 1000
1 ≤ W ≤ 1000
1 ≤ wt[i] ≤ 1000
1 ≤ v[i] ≤ 1000
 */

// Recurssive 
class Solution 
{ 
    int[][] dp;
    Solution(){}
    Solution(int N, int W){
        dp = new int[N+1][W+1];
        for(int i = 0;i<=N;i++)
            Arrays.fill(dp[i],-1);
    }
    
    public  int zeroOneKnapSack(int[] Wt, int V[], int W, int N){
        if(W==0 || N==0) return 0;
        if(dp[N][W]!=-1){
            return dp[N][W];
        }
        if(Wt[N-1]<=W){
            return dp[N][W] = Math.max(
                                        V[N-1]+zeroOneKnapSack(Wt,V,W-Wt[N-1],N-1),
                                        zeroOneKnapSack(Wt,V,W,N-1)
                                    );
        }
        else{
            return dp[N][W] = zeroOneKnapSack(Wt,V,W,N-1);
        }
    }
    
     int knapSack(int W, int wt[], int val[], int n) 
    { 
        Solution s = new Solution(n,W);
        int res = s.zeroOneKnapSack(wt,val,W,n);
        return res;
    } 
}


// Top Down


class Solution 
{ 
    static int knapSack(int W, int wt[], int val[], int N) 
    { 
        int[][] dp = new int[N+1][W+1];
        for(int n=1;n<=N;n++)
        for(int w=1;w<=W;w++)
            if(wt[n-1]<=w)
                dp[n][w] = Math.max(val[n-1] + dp[n-1][w-wt[n-1]], dp[n-1][w]);
            else
                dp[n][w] = dp[n-1][w];
        return dp[N][W]; 
    } 
}