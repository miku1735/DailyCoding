


// Longest Palindromic Subsequence

/**
 * Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
 

Constraints:

1 <= s.length <= 1000
s consists only of lowercase English letters.
 */

class Solution {
    public int longestPalindromeSubseq(String s1) {
        
        StringBuffer str = new StringBuffer(s1);
        str.reverse();
        String s2 = str.toString();
        
        int x = s1.length(); 
        int y = x;
        
	    int[][] dp = new int[x+1][y+1];
       
        for(int i=1; i<=x; i++)
        for(int j=1; j<=y; j++)
            if(s1.charAt(i-1) == s2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
            else
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
        
        return dp[x][y];
        
    }
}