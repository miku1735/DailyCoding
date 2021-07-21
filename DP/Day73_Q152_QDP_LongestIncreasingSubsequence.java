



// Longest Increasing Subsequence


/**
 * Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A[]={0,8,4,12,2,10,6,14,1,9,5
     13,3,11,7,15}
Output: 6
Explanation:Longest increasing subsequence
0 2 6 9 13 15, which has length 6
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 3
Explanation:Longest increasing subsequence
5 7 9, with length 3
Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( N*log(N) )
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
0 ≤ A[i] ≤ 106
 */

//  not Accepted in GFG O(n*n)
class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[])
    {
        int dp[] = new int[n];
        if(n == 0) return 0;
        if(n == 1) return 1;
        dp[0] = 1;
        
        int res = 0;
        for(int i = 1; i<n; i++){
            int max = 0;
            for(int j = i-1; j>=0 ; j--){
                if(a[i] > a[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i]  = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
} 



// O(nlogn) Accepted binary search

class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int a[])
    {
        int dp[] = new int[n+1];
        if(n == 0) return 0;
        if(n == 1) return 1;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int idx = Arrays.binarySearch(dp,a[i]);
            if(idx<0){
                dp[Math.abs(idx)-1] = a[i];
            }
        }
        int res = 0;
        for(int i=n; i>=0; i--){
            if(dp[i]!=Integer.MAX_VALUE){
                res = i;
                break;
            }
        }
        return res;
    }
} 