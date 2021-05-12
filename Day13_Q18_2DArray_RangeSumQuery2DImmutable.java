




//Range Sum Query 2D - Immutable


/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:

    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * TheImplement the NumMatrix class:

    NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 
 */


 /**
  * Input
    ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
    [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
    Output
    [null, 8, 11, 12]

    Explanation
    NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
    numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
    numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
    numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
  */


  /**
   * 
Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 200
    -105 <= matrix[i][j] <= 105
    0 <= row1 <= row2 < m
    0 <= col1 <= col2 < n
    At most 104 calls will be made to sumRegion.
   */



  class NumMatrix {
    int sumArray[][];
    public NumMatrix(int[][] matrix) {
        sumArray = new int[matrix.length][matrix[0].length];
        sumArray[0][0] = matrix[0][0];
        int row = matrix.length;
        int col = matrix[ 0 ].length;
        if(matrix.length>1 || matrix[0].length>1){
            for(int i=0;i<row;i++){
                for(int j = 0;j<col;j++){
                    if(i==0 && j==0) continue;
                    if(i==0){
                        sumArray[i][j] = sumArray[i][j-1] + matrix[i][j];
                    }
                    else if(j==0){
                        sumArray[i][j] = sumArray[i-1][j] + matrix[i][j];
                    }
                    else {
                        sumArray[i][j] = sumArray[i-1][j] + sumArray[i][j-1] - sumArray[i-1][j-1] + matrix[i][j];
                    }
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int finalSum = sumArray[row2][col2];
        if(row1!=0){
            finalSum -= sumArray[row1-1][col2];
        }
        if(col1!=0){
            finalSum -= sumArray[row2][col1-1];
        }
        if(row1!=0 && col1!=0){
            finalSum += sumArray[row1-1][col1-1];
        }
        return finalSum;
    }
}