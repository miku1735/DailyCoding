


// Shortest Common Supersequence


/**
 * Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
Note: X and Y can have both uppercase and lowercase letters.

Example 1

Input:
X = abcd, Y = xycd
Output: 6
Explanation: Shortest Common Supersequence
would be abxycd which is of length 6 and
has both the strings as its subsequences.
Example 2

Input:
X = efgh, Y = jghi
Output: 6
Explanation: Shortest Common Supersequence
would be ejfghi which is of length 6 and
has both the strings as its subsequences.
Your Task:
Complete shortestCommonSupersequence() function that takes X, Y, m, and n as arguments and returns the length of the required string.

Expected Time Complexity: O(Length(X) * Length(Y)).
Expected Auxiliary Space: O(Length(X) * Length(Y)).

Constraints:
1<= |X|, |Y| <= 100
 */


//All char of both the strings minus the LCS 

class Solution
{
    public static int shortestCommonSupersequence(String s1,String s2,int x,int y)
    {
        int[][] dp = new int[x+1][y+1];
        
        for(int i=1; i<=x; i++)
        for(int j=1; j<=y; j++)
            if(s1.charAt(i-1) == s2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
            else
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
        
        return x+y-dp[x][y];
    }
}

//keep eye on initialization

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int[][] dp =  new int[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if (i==0) dp[i][j] = j;
                if (j==0) dp[i][j] = i;
            }
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}