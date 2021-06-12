



// Check if All the Integers in a Range Are Covered



/**
 * You are given a 2D integer array ranges and two integers left and right. Each ranges[i] = [starti, endi] represents an inclusive interval between starti and endi.

Return true if each integer in the inclusive range [left, right] is covered by at least one interval in ranges. Return false otherwise.

An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.

 

Example 1:

Input: ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
Output: true
Explanation: Every integer between 2 and 5 is covered:
- 2 is covered by the first range.
- 3 and 4 are covered by the second range.
- 5 is covered by the third range.
Example 2:

Input: ranges = [[1,10],[10,20]], left = 21, right = 21
Output: false
Explanation: 21 is not covered by any range.
 

Constraints:

1 <= ranges.length <= 50
1 <= starti <= endi <= 50
1 <= left <= right <= 50
 */

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges,(a,b)->a[0]-b[0]);
        
        // for(int i=0;i<ranges.length;i++){
        //     System.out.print(Arrays.toString(ranges[i]));
        // }
        int getLeft = -1;
        int getRight = -1;
        for(int i=0;i<ranges.length;i++){
            int[] temp = ranges[i];
            if(right>=temp[0] && right<=temp[1]){
                getRight = i;
                break;
            } 
        }
        for(int i=0;i<ranges.length;i++){
            int[] temp = ranges[i];
            if(left>=temp[0] && left<=temp[1]){
               getLeft = i;
                break;
            } 
        }
                // System.out.print(getLeft + " "+ getRight);

        if(getLeft==-1 || getRight==-1) return false;
        if(getLeft == getRight) return true;
        
        
        
        int max  = ranges[getLeft][1];
        for(int i=getLeft+1;i<=getRight;i++){
             int[] temp = ranges[i];
            if(max>temp[0]){
                max=Math.max(max,temp[1]);
               continue ;
            } 
            else{
                if(temp[0] - max>1) return false;
                else{
                    max = temp[1];
                }
            }
        }
        return true;
    }
}