




// N Queens II

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
 */



class Solution {
        
    int res =0;
    public boolean safe(Character a[][],int row, int col){
        int count = 0;
        // down
        for(int i = 0;i<a.length;i++){
            if(i==row) continue;
            if(a[i][col]=='Q'){
                count++;
            }
        }
        //digonal
        for(int i=row+1,j=col+1 ;i<a[0].length&&j<a.length;i++,j++){
            if(a[i][j]=='Q'){
                count++;
            }
        }
        for(int i=row-1,j=col-1 ;i>=0 && j>=0;i--,j--){
            if(a[i][j]=='Q'){
                count++;
            }
        }
        for(int i=row+1,j=col-1 ;i<a.length&&j>=0;i++,j--){
            if(a[i][j]=='Q'){
                count++;
            }
       }
        for(int i=row-1,j=col+1 ;i>=0&&j<a.length;i--,j++){
            if(a[i][j]=='Q'){
                count++;
            }
        }
        return count>0?false:true;
    }
    public void findPositionOfQueens(Character a[][],int nthQueen){
        for(int i =0;i<a[0].length;i++){
            a[nthQueen][i] = 'Q';
            if(nthQueen+1==a.length){
                if(safe(a,nthQueen, i)){
                    res++;
                }
            }    
            else if(safe(a,nthQueen, i)){                
                findPositionOfQueens(a,nthQueen+1);
            }
            a[nthQueen][i] = '.';
        }
    }
    public int totalNQueens(int n){
        Character[][] a = new Character[n][n] ;
        for(int i=0;i<n;i++){
            Arrays.fill(a[i],'.');
        }
        findPositionOfQueens(a,0);
        return res;
    }
}