



//Longest subsequence-1


/**
 * Given an array A[] of size N, find the longest subsequence such that difference between adjacent elements is one.


Example 1:

Input: N = 7
A[] = {10, 9, 4, 5, 4, 8, 6}
Output: 3
Explaination: The three possible subsequences 
{10, 9, 8} , {4, 5, 4} and {4, 5, 6}.

Example 2:

Input: N = 5
A[] = {1, 2, 3, 4, 5}
Output: 5
Explaination: All the elements can be 
included in the subsequence.

Your Task:
You do not need to read input. Your task is to complete the function longestSubseq() which takes N and A[] as input parameters and returns the length of the longest such subsequence.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 103
1 ≤ A[i] ≤ 103
 */

class Solution{
    static int longestSubsequence(int N, int A[])
    {
        int[] dp = new int[N];
        
        if(N==0 || N==1) return N;
        dp[0] = 1;
        
        for(int i = 1; i<N; i++){
            int max = 0;
            for(int j = i-1; j>=0; j--){
                if(A[j] == A[i]+1 || A[j] == A[i]-1)
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max>0?max+1:1;
        }
        int max = -1;
        for(int i = 1; i<N; i++)
            max = Math.max(max, dp[i]);
        return max;
    }
}