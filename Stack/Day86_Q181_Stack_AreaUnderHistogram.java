




// Maximum Rectangular Area in a Histogram


/**
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit.

Example 1:

Input:
N = 7
arr[] = {6,2,5,4,5,1,6}
Output: 12
Explanation: 


Example 2:

Input:
N = 8
arr[] = {7 2 8 9 1 3 6 5}
Output: 16
Explanation: Maximum size of the histogram 
will be 8  and there will be 2 consecutive 
histogram. And hence the area of the 
histogram will be 8x2 = 16.
Your Task:
The task is to complete the function getMaxArea() which takes the array arr[] and its size N as inputs and finds the largest rectangular area possible and returns the answer.

Expected Time Complxity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 ≤ N ≤ 106
1 ≤ arr[i] ≤ 1012
 */


class Solution
{
    public static long getMaxArea(long arr[], long n) 
    {
       Stack<Integer> s = new Stack<>();
        
        s.push(-1);
        long max_area = arr[0];
        long left_smaller[] = new long[(int)n];
        long right_smaller[] = new long[(int)n];
        for (int i = 0; i < n; i++){
            left_smaller[i] = -1;
            right_smaller[i] = n;
        }
 
        int i = 0;
        while (i < n)
        {
            while(!s.empty()&&s.peek()!=-1&&arr[i]<arr[s.peek()]){
                right_smaller[s.peek()] = (int)i;
                s.pop();
            }
            if(i>0&&arr[i]==arr[(i-1)]){
                left_smaller[i] = left_smaller[(int)(i-1)];
            }else{
                left_smaller[i] = s.peek();
            }
            s.push(i);
            i++;
        }
 
 
        for(i = 0; i<n; i++){
            max_area = Math.max(max_area, arr[i]*(right_smaller[i] - left_smaller[i] - 1));
        }
 
        return max_area;
    }
        
}