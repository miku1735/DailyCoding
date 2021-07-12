
// Form a palindrome

/**
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd


Example 1:

Input: str = "abcd"
Output: 3
Explanation: Inserted character marked
with bold characters in dcbabcd
Example 2:

Input: str = "aa"
Output: 0
Explanation:"aa" is already a palindrome.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function countMin() which takes the string str as inputs and returns the answer.

Expected Time Complexity: O(N2), N = |str|
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ |str| ≤ 103
str contains only lower case alphabets.
 */

class Solution{
    static int countMin(String s1)
    {
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
        
        return x-dp[x][y];
    }
}