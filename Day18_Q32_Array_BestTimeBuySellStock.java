


/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e., max profit = 0.
 

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */


class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1) return 0;
        if(prices.length==2) {
            int val = prices[1]-prices[0];
            if(val>0)return val;
            else return 0;
        }
        int start=prices[0], end=0;
        int totalProfit = 0;
        for(int i = 1; i<prices.length;i++){
            if(prices[i]<=start){
                start = prices[i];
            }
            else{
                end = start;
                int j = i;
                for(; j<prices.length;j++){
                    if(prices[j]>=end){
                        end = prices[j];
                    }
                    else break;
                }
                i=j-1;
                totalProfit += end - start; 
                start = end;
            }
        }
        return totalProfit;
    }
}