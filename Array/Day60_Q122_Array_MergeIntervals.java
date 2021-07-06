



// Mergre Intervals


/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */


class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<List<Integer>> temp = new ArrayList();
        for(int i = 0; i<n;i++){
            List<Integer> col = new ArrayList();
            col.add(intervals[i][0]);
            int highest = intervals[i][1];
            while(i<n){
                int[] a = intervals[i];
                highest = Math.max(highest,intervals[i][1]);
                if(!(i+1<n)) break;
                int[] b = intervals[i+1];
                if(highest<b[0]) break;
                i++;
            }
            col.add(highest);
            temp.add(col);
        }
        int[][] res = new int[temp.size()][2];
        for(int i = 0;i<temp.size();i++){
            res[i][0] = temp.get(i).get(0);
            res[i][1] = temp.get(i).get(1); 
        }
        return res;
    }
}