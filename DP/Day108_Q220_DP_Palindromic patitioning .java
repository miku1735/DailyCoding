


// Palindromic patitioning 

/**
 * Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. Determine the fewest cuts needed for palindrome partitioning of given string.


Example 1:

Input: str = "ababbbabbababa"
Output: 3
Explaination: After 3 partitioning substrings 
are "a", "babbbab", "b", "ababa".

Example 2:

Input: str = "aaabba"
Output: 1
Explaination: The substrings after 1
partitioning are "aa" and "abba".


Your Task:
You do not need to read input or print anything, Your task is to complete the function palindromicPartition() which takes the string str as input parameter and returns minimum number of partitions required.


Expected Time Complexity: O(n*n) [n is the length of the string str]
Expected Auxiliary Space: O(n*n)


Constraints:
1 ≤ length of str ≤ 500
 */

class Solution{
    
    int dp[][];
    boolean isPalindrome(String str, int start, int end){
        str = str.substring(start, end+1);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
    
    int findLength(String str, int start, int end){
        if(start>=end || isPalindrome(str, start, end)) return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[start][end]!= 0) return dp[start][end];
        for(int mid = start;mid<=end-1;mid++){
            int left, right;
            if(dp[start][mid]==0) dp[start][mid] = left = findLength(str, start, mid);
            else left = dp[start][mid];
            
            if(dp[mid+1][end]==0) dp[mid+1][end] = right = findLength(str, mid+1, end);
            else right = dp[mid+1][end];
            int temp = left + right + 1;
            dp[start][end] = temp;
            ans = Math.min(ans, temp);
        }
        return dp[start][end] = ans;
    } 
    int palindromicPartition(String str)
    {
        int size = str.length();
        dp = new int[size][size];
        int res =  findLength(str, 0, size-1);
        return res;
    }
}