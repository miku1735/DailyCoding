


// Maximum sum increasing subsequence


/**
 * Given an array arr of N positive integers, the task is to find the maximum sum increasing subsequence of the given array.
 

Example 1:

Input: N = 5, arr[] = {1, 101, 2, 3, 100} 
Output: 106
Explanation:The maximum sum of a
increasing sequence is obtained from
{1, 2, 3, 100}
Example 2:

Input: N = 3, arr[] = {1, 2, 3}
Output: 6
Explanation:The maximum sum of a
increasing sequence is obtained from
{1, 2, 3}

Your Task:  
You don't need to read input or print anything. Complete the function maxSumIS() which takes N and array arr as input parameters and returns the maximum value.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 105
 */

class Solution
{
	public int maxSumIS(int a[], int n)  
	{  
	    int dp[] = new int[n];
        if(n == 0) return 0;

        int res = 0;
        for(int i = 0; i<n; i++){
            int max = 0;
            for(int j = i-1; j>=0 ; j--){
                if(a[i] > a[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i]  = max + a[i];
            res = Math.max(res, dp[i]);
        }
        return res;
	}  
}