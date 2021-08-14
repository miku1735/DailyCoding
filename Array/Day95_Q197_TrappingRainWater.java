



// Traping Rain Waters 

/**
 * Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation: 

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

Your Task:
You don'y need to read input or print anything. The task is to complete the function trappingWater() which takes arr and N as input parameters and returns the total amount of water that can be trapped.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 */

// with space
class Solution{
    static int trappingWater(int arr[], int n) { 
        int[] left = new int[n];
        int[] right = new int[n];
        int result = 0;
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], arr[i-1]);
            right[n-1-i] = Math.max(right[n-i], arr[n-i]);
        }
        for(int i=1;i<n-1;i++){
            int min  = Math.min(left[i], right[i]);
            if(min>arr[i]) result += min - arr[i];
        }
        return result;
    } 
}


// without space
class Solution{
    static int trappingWater(int arr[], int n) { 
        // two pointer method O(n)
        int i=0, j=n-1, leftMax=0, rightMax=0, ans=0;
        
        while(i<=j){
            if(leftMax<=rightMax){
                if(arr[i]>leftMax) leftMax = arr[i];
                else{
                    ans += leftMax-arr[i];
                }
                i++;
            }
            else{
                if(arr[j]> rightMax) rightMax = arr[j];
                else{
                    ans += rightMax-arr[j];
                }
                j--;
            }
        }
        return ans;
    } 
}