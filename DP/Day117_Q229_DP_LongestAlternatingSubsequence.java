



A sequence {x1, x2, .. xn} is alternating sequence if its elements satisfy one of the following relations :
x1 < x2 > x3 < x4 > x5..... or  x1 >x2 < x3 > x4 < x5.....
Your task is to find the longest such sequence.

Example 1:

Input: nums = {1,5,4}
Output: 3
Explanation: The entire sequenece is a 
alternating sequence.
Examplae 2:

Input: nums = {1,17,5,10,13,15,10,5,16,8}
Output: 7
Explanation: There are several subsequences
that achieve this length. 
One is {1,17,10,13,10,16,8}.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function AlternatingaMaxLength() which takes the sequence  nums as input parameter and returns the maximum length of alternating sequence.

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)





DP (N^2)

class Solution
{
    public int AlternatingaMaxLength(int[] arr)
    {
        
        int len = arr.length;
        
        int[][] dp = new int[2][len];
        for(int i=0; i<len; i++)
            dp[0][i] = dp[1][i] = 1;
        
        for(int i=1; i<len; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[0][i] = Math.max(dp[0][i], dp[1][j]+1);
                }
                else if(arr[j]>arr[i]){
                    dp[1][i] = Math.max(dp[1][i], dp[0][j]+1);
                }
            }
        }
        return Math.max(dp[0][len-1], dp[1][len-1]);
    }
}




O(N)
int a=1,b=1;

for(int i=1;i<arr.length;i++){
    if(arr[i]>arr[i-1]){
        a = b+1;
    }
    else if(arr[i]<arr[i-1]){
        b = a+1; 
    }
}
return Math.max(a,b);
