


// Pascals Triangle

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
 
 */


class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        if(n==0) return ans;
        for(int i = 1;i<=n;i++){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for(int j= 0;j<i-1;j++){
                temp.add(ans.get(j) + ans.get(j+1));
            }
            temp.add(1);
            ans = temp;
        }
        return ans;
    }
}