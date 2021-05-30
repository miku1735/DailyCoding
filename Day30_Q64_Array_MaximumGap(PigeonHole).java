


// Max Gap


/**
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.

 

Example 1:

Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 109
 */


class Solution {
    public int maximumGap(int[] nums) {
      if(nums.length==1) return 0;
      if(nums.length==2) return Math.abs(nums[0]-nums[1]);
      int max = 0;
      int min = Integer.MAX_VALUE;
      for(int i=0; i<nums.length;i++){
        min = Math.min(min,nums[i]);
        max = Math.max(max,nums[i]);
      }
      
      int buckets = nums.length-1;
      System.out.println("Max Min Buckets"+min+" "+ max+" "+ buckets);
      List<Integer> state[] = new ArrayList[buckets];
      for(int i = 0;i<buckets;i++){  // Length of array - 2(min,Max) + 1 (we are taking 1 more bucket)
        state[i] = new ArrayList();
      }
      
      state[0].add(min);
      state[buckets-1].add(max);
      int bucketSize = (int)Math.ceil((double)(max-min)/(buckets));
      System.out.println("size"+bucketSize);
      for(int i=0; i<=buckets;i++){
        if(nums[i]==min || nums[i]==max) continue;
        state[(nums[i]-min)/bucketSize].add(nums[i]);
      }

      for(int i=0;i<state.length;i++)
        System.out.println(state[i]);
      int maxDiff = 0;
      min = 0;
      max = Collections.max(state[0]);
      for(int i = 1;i<state.length;i++){
        if(state[i].size()==0) continue; 
        
        int dif = Collections.min(state[i]) - max;
        maxDiff = Math.max(dif,maxDiff);
        max = Collections.max(state[i]);
      }
      
      return maxDiff;
    }
}