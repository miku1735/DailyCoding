


// Jump Game VI



/**
 * You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

Return the maximum score you can get.

 

Example 1:

Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.
Example 2:

Input: nums = [10,-5,-2,4,0,3], k = 3
Output: 17
Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.
Example 3:

Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
Output: 0
 

Constraints:

 1 <= nums.length, k <= 105
-104 <= nums[i] <= 104
 */



 // Time Complexity :- (n*k)   (NOT ACCEPTED) TLE
class Solution {
    int dp[] ;
    Queue<int[]> q = new PriorityQueue<>((int a[], int b[])->b[1]-a[1]);
    public int getMaxResult(int[] nums, int k, int index){
        if(index == nums.length-1){
            dp[index] = nums[index];
            return dp[index];
        } 
        if(index>nums.length-1) return 0;
        if(dp[index]!=-1) return dp[index];
        
        dp[index] = Integer.MIN_VALUE;
        for(int i=1;i<=k;i++){
            int nextIndex = Math.min(nums.length-1,index+i);
            dp[index] = Math.max(dp[index],getMaxResult(nums,k,nextIndex));
        }
        dp[index] += nums[index];
        q.add(new int[] {dp[index],index});
        return dp[index];
    }
    public int maxResult(int[] nums, int k) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int res =  getMaxResult(nums,k,0);
        System.out.print(Arrays.toString(dp));
        return res;
    }
}


// Time Complexity :- (n*k) same solution with loops     (NOT ACCEPTED) TLE
class Solution {
    public int maxResult(int[] nums, int k) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,0);
        for(int i = nums.length-1;i>=0;i--){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<=k;j++){
                int nextIndex = Math.min(nums.length-1, i+j);
                max = Math.max(max, dp[nextIndex]);
            }
            dp[i]=max+nums[i];
        }
        System.out.print(Arrays.toString(dp));
        return dp[0];
    }
}


// Time Complexity :- (nlogk) Accepted
class Solution {
    public int maxResult(int[] nums, int k) {
        Queue<int[]> q = new PriorityQueue<>((a, b)-> b[0]-a[0]); 
        q.add(new int[]{nums[0],0});
        int res=nums[0];
        for(int i = 1;i<nums.length;i++){            
            while(q.peek()[1]<i-k) q.poll();
            res = q.peek()[0] + nums[i];
            q.add(new int[]{res,i});
        }
        return res;
    }
}

// Time Complexity :- (nlogk) Accepted
class Solution {
    public int maxResult(int[] nums, int k) {
        Queue<int[]> q = new PriorityQueue<>((a, b)-> b[0]-a[0]); 
        q.add(new int[]{nums[nums.length-1],nums.length-1});
        int res=nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--){            
            while(q.peek()[1]>i+k) q.poll();
            res = q.peek()[0] + nums[i];
            q.add(new int[]{res,i});
        }
        return res;
    }
}


// Time Complexity :- (n) Accepted

//Deque
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);
          for (int i = 1; i < n; ++i) { 
            nums[i] = nums[dq.peekFirst()] + nums[i];
           while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i - dq.peekFirst() >= k) dq.pollFirst();
        }
        return nums[nums.length-1];
    }
 }







