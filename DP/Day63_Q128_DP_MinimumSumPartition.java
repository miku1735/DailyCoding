


// Minimum sum partition


/**
 * Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference


Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4

Your Task:  
You don't need to read input or print anything. Complete the function minDifference() which takes N and array arr as input parameters and returns the integer value


Expected Time Complexity: O(N*|sum of array elements|)
Expected Auxiliary Space: O(N*|sum of array elements|)


Constraints:
1 ≤ N*|sum of array elements| ≤ 106
 */

class Solution
{
	public int minDifference(int arr[], int N) 
	{ 
	    int sum =0;
        for(int i=0;i<N;i++) sum+=arr[i];
        int W = sum;
        int[][] dp = new int[N+1][W+1];
        for(int i=0;i<=N;i++)
        for(int j=0;j<=W;j++){
            if(i==0) dp[i][j] = 0;
            if(j==0) dp[i][j] = 1;
        }
        for(int n=1;n<=N;n++)
        for(int w=1;w<=W;w++)
            if(arr[n-1]<=w)
                dp[n][w] = Math.max(dp[n-1][w-arr[n-1]], dp[n-1][w]);
            else
                dp[n][w] = dp[n-1][w];
            
        int minDiff = Integer.MAX_VALUE; 
        for(int i=0;i<=W;i++){
            if(dp[N][i]==1) minDiff = Math.min(minDiff, sum-2*i>=0?sum-2*i:minDiff);
        }
        return minDiff; 
	} 
}