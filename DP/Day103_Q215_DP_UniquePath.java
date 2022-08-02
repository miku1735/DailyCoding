



// Unique Paths

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
 */


//Grapgh Solution ------>>>>> Not Accepted
class Solution {
    
    int totalPath = 0;
    public void DFS(int[][] board, int i, int j, int row, int col){
        if(i == row-1 && j == col-1){
            totalPath++;
            return;
        }
        
        if(j<=col-2 && board[i][j+1] != 1){
            board[i][j+1] = 1;
            DFS(board, i, j+1, row, col);
            board[i][j+1] = 0;
        }
        if(i<=row-2 && board[i+1][j] != 1){
            board[i+1][j] = 1;
            DFS(board, i+1, j, row, col);
            board[i+1][j] = 0;
        }
    }
    
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        
        board[0][0] = 1;
        
        DFS(board, 0, 0, m, n);
        return totalPath;
    }
}


class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int j = 0;j<n;j++){
            dp[m-1][j] = 1;
        }
        for(int i = 0;i<m;i++){
            dp[i][n-1] = 1;
        }    
        for(int i = m-2;i>=0;i--)
            for(int j = n-2;j>=0;j--){
                if(j<n-1) dp[i][j] += dp[i][j+1];
                if(i<m-1) dp[i][j] += dp[i+1][j];
            }
        return dp[0][0];
    }
}