


//Delete Operation for Two Strings

/**
    Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

    In one step, you can delete exactly one character in either string.
 */

/**
 * Example 1:

    Input: word1 = "sea", word2 = "eat"
    Output: 2
    Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
*/

/**
 * Example 2:

    Input: word1 = "leetcode", word2 = "etco"
    Output: 4
*/

/**
  * Constraints:

    1 <= word1.length, word2.length <= 500
    word1 and word2 consist of only lowercase English letters.
*/


class Solution {  
    int dp[][];
    public int LongestCommonSubsequence(String word1, String word2,int w1,int w2){
        if(w2>word2.length()-1 || w1>word1.length()-1) return 0;
        if(word1.charAt(w1) == word2.charAt(w2)){
            if(dp[w1][w2]!=-1){
                return dp[w1][w2];
            }
            else{
                dp[w1][w2] = LongestCommonSubsequence(word1,word2,w1+1,w2+1)+1;
                return dp[w1][w2];
            } 
        }
        else{
            if(dp[w1][w2]!=-1){
                return dp[w1][w2];
            }
            else{
                dp[w1][w2] =Math.max(LongestCommonSubsequence(word1,word2,w1+1,w2),
                                     LongestCommonSubsequence(word1,word2,w1,w2+1)
                                    );
                return dp[w1][w2];
            }
        }
    }
    
    
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i], -1);
        }
        return word1.length()+word2.length() - 2 * LongestCommonSubsequence(word1,word2,0,0);        
    }
}