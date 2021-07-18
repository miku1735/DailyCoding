

//Edit Distance

/**
 * Given two strings s and t. Find the minimum number of operations that need to be performed on str1 to convert it to str2. The possible operations are:

Insert
Remove
Replace
 

Example 1:

Input: 
s = "geek", t = "gesek"
Output: 1
Explanation: One operation is required 
inserting 's' between two 'e's of str1.
Example 2:

Input : 
s = "gfg", t = "gfg"
Output: 
0
Explanation: Both strings are same.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function editDistance() which takes strings s and t as input parameters and returns the minimum number of operation required to make both strings equal. 


Expected Time Complexity: O(|s|*|t|)
Expected Space Complexity: O(|s|*|t|)


Constraints:
1 ≤ Length of both strings ≤ 100
Both the strings are in lowercase.
 */

class Solution {
    public int editDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];
        
        //initialize
        for(int i = 0; i<=len1; i++)
        for(int j = 0; j<=len2; j++){
            if(i==0) dp[i][j] = j;
            if(j==0) dp[i][j] = i;
        }

        //dp building
        for(int i = 1; i<=len1; i++)
        for(int j = 1; j<=len2; j++){
            //Math.min(replace,Math.min(Remove, insert));
            if(s.charAt(i-1)==t.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
            else
                dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
        }
        return dp[len1][len2];
    }
}