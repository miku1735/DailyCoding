



//Interleaving String


/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 

Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
 

Follow up: Could you solve it using only O(s2.length) additional memory space?
 */


class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if ((len1+len2)!=len3) return false;

        boolean[][] dp = new boolean[len2+1][len1+1];

        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++){
            dp[0][i] = dp[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < dp.length; i++){
            dp[i][0] = dp[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                dp[i][j] = (dp[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                        || (dp[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }

        return dp[len2][len1];
    }
}