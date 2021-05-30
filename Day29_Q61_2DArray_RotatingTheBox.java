



//Rotating the Box


/**
 * You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

 

Example 1:



Input: box = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]
Example 2:



Input: box = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]
Example 3:



Input: box = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]
 

Constraints:

m == box.length
n == box[i].length
1 <= m, n <= 500
box[i][j] is either '#', '*', or '.'.
 */

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        for(int i=0;i<box.length;i++){
          int j=0;
          while(j<box[0].length){
            int starIndex = 0;
            while(true){
              if(j==box[0].length) break;
              if(box[i][j] == '*') break;
              j++;
            }
            starIndex = j;
            int hashIndex = starIndex - 1;
            for(int k = hashIndex; ; k--){
              if(k<0 || box[i][k] == '*') break;
              if(box[i][k] == '#'){
                box[i][k]='.';
                box[i][hashIndex]='#';
                hashIndex--;
              }
            }
            j++;
          }
        }
      int n = box.length;
      int m = box[0].length;
      char res[][] = new char[box[0].length][box.length];
      for (int i=0; i<n; i++)
      for (int j=0;j<m; j++)
        res[j][n-1-i] = box[i][j];
      return res;
    }
}