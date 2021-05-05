

//Jump Game II


/**
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    You can assume that you can always reach the last index.
*/


 /**
  * Example 1:

    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

/**
 * Example 2:

    Input: nums = [2,3,0,1,4]
    Output: 2
*/
/**
 * Constraints:

    1 <= nums.length <= 1000
    0 <= nums[i] <= 105
 */

class Solution {
    int a[];
    int totalJump = 0;
    
    public void total(int[] nums){
        for(int index=nums.length-2;index > -1; index--){
            if(nums[index]==0){
                a[index]=Integer.MAX_VALUE;
            }
            else{
                int localMin = Integer.MAX_VALUE;
                for(int i=1;i<=nums[index];i++){
                    int newIndex = index+i;
                    if(newIndex<=nums.length-1){
                        localMin = localMin > a[newIndex]?a[newIndex]:localMin;
                    }

                }
                a[index] = localMin==Integer.MAX_VALUE?Integer.MAX_VALUE:localMin+1;
            }
        }
    }
    public int jump(int[] nums) {
        a = new int[nums.length];
        a[nums.length-1]=0;
        total(nums);
        return a[0];
    }
}