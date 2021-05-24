


//Pascal's Triangle


/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> res = new ArrayList();
      List<Integer> row = new ArrayList();
      row.add(1);
      res.add(row);
      if(numRows==1){
        return res;
      }
      row = new ArrayList();
      row.add(1);row.add(1);
      res.add(row);
      if(numRows==2){
        return res;
      }
      for(int i = 2; i<numRows; i++){
        List<Integer> prevRow = res.get(i-1);
        row = new ArrayList();
        row.add(1);
        for(int j=1; j<prevRow.size();j++){
          row.add(prevRow.get(j-1)+prevRow.get(j));
        }
        row.add(1);
        res.add(row);
      }
      return res;
    }
}