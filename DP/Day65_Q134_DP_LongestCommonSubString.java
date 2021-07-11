



// Longest Common SubString


/**
 * Given two strings. The task is to find the length of the longest common substring.


Example 1:

Input: S1 = "ABCDGH", S2 = "ACDGHR"
Output: 4
Explanation: The longest common substring
is "CDGH" which has length 4.
Example 2:

Input: S1 = "ABC", S2 "ACB"
Output: 1
Explanation: The longest common substrings
are "A", "B", "C" all having length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestCommonSubstr() which takes the string S1, string S2 and their length n and m as inputs and returns the length of the longest common substring in S1 and S2.


Expected Time Complexity: O(n*m).
Expected Auxiliary Space: O(n*m).


Constraints:
1<=n, m<=1000
 */


class Solution{
    int longestCommonSubstr(String s1, String s2, int x, int y){
        int[][] dp = new int[x+1][y+1];
        
        for(int i=1; i<=x; i++)
        for(int j=1; j<=y; j++)
            if(s1.charAt(i-1) == s2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
            else
                dp[i][j] = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<=x; i++)
            max = Math.max(max, Arrays.stream(dp[i]).max().getAsInt());
        return max;
    }
}