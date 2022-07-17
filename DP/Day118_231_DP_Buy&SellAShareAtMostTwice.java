

// Buy and Sell a Share at most twice 
// Medium Accuracy: 57.59% Submissions: 3722 Points: 4
// In daily share trading, a buyer buys shares in the morning and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, the second transaction can only start after the first one is complete (Buy->sell->Buy->sell). The stock prices throughout the day are represented in the form of an array of prices. 

// Given an array price of size N, find out the maximum profit that a share trader could have made.

// Example 1:

// Input:
// 6
// 10 22 5 75 65 80
// Output:
// 87
// Explanation:
// Trader earns 87 as sum of 12, 75 
// Buy at 10, sell at 22, 
// Buy at 5 and sell at 80
// Example 2:

// Input:
// 7
// 2 30 15 10 8 25 80
// Output:
// 100
// Explanation:

// Trader earns 100 as sum of 28 and 72
// Buy at price 2, sell at 30,
// Buy at 8 and sell at 80
// Your Task:

// Complete the function maxProfit() which takes an integer array price as the only argument and returns an integer, representing the maximum profit, if only two transactions are allowed.

// Expected Time Complexity: O(N^3)

// Expected Space Complexity: O(N)

// Constraints:

// 1 <= N <= 105
// 1 <= price[i] <= 105




























class Solution {
    
    static int[][][] dp;
    
    public static int findProfit(int i, int buy, int cap, int n, int[] price){
        
        if(cap == 0) return 0;
        if(n == i) return 0;
        int profit = 0;
        
        if (dp[i][buy][cap] !=-1) return dp[i][buy][cap];
        
        if(buy==1){
            profit = Math.max(
                    -price[i] + findProfit(i+1, 0, cap, n, price),
                        0     + findProfit(i+1, 1, cap, n, price)
                );
        }
        else{
            profit = Math.max(
                    price[i] + findProfit(i+1, 1, cap-1, n, price),
                        0    + findProfit(i+1, 0, cap, n, price)
                );
        }
        return dp[i][buy][cap] = profit;
        
    } 
    
    public static int maxProfit(int n, int[] price) {
        
        int cap = 2;
        int buy = 1;
        
        dp = new int[n][2][3];
        
        for(int i=0; i<n;i++){
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
        
        
        
        return findProfit(0, buy, cap, n, price);
    }
}