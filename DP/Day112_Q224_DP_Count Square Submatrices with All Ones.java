
// Count Square Submatrices with All Ones


/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 */

class Solution {
    public int countSquares(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = matrix[0][0];
        
        for(int i = 1;i<m;i++){
            if(matrix[i][0]==1) ans++;
        }
        for(int i = 1;i<n;i++){
            if(matrix[0][i]==1) ans++;
        }
        
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(matrix[i][j] == 0) continue;
                if(matrix[i-1][j]==0 || matrix[i][j-1] == 0 || matrix[i-1][j-1] == 0){
                    ans++;
                }
                else{
                    int min = Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                    matrix[i][j] = min + 1;
                    ans += (min + 1);
                }
            }
        }
        return ans;
    }
}