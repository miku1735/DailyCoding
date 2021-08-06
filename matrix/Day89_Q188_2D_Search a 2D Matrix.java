

// Search a 2D Matrix

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int ar[] = new int[1];
        for(int i = 0;i<matrix.length;i++){
            if(target == matrix[i][0] || (i != matrix.length-1 && target==matrix[i+1][0])){
                return true;
            }
            else if(i == matrix.length-1 && target > matrix[i][0]){
                ar = matrix[i];
            }
            else if(target > matrix[i][0] && target<matrix[i+1][0]){
                ar = matrix[i];
            }
        }
        return Arrays.binarySearch(ar,target)>0?true:false;
    }
}