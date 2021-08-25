


// Longest Palindromic Substring

/** 
 * Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int ansX=0,ansY=0;
        int x = 0, y = 0;
        
        while(x<n){
            dp[x][y] = 1;
            if(y<n-1 && s.charAt(y+1) == s.charAt(x)){ 
                dp[x][y+1] = 1;
                ansX = x;
                ansY = y+1;
            } 
            x++;
            y++;
        }
        
        for(int i = 2;i<n;i++){
            int a=0,b=i;
            while(b<n){
                if(s.charAt(a) == s.charAt(b) && dp[a+1][b-1]==1){
                   dp[a][b] = 1;
                   ansX = a;
                   ansY = b;
                }
                a++;b++;
            }
        }
        return s.substring(ansX,ansY+1);
    }
}