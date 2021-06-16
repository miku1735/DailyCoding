




// Matchsticks to Square


/**
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

 

Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
 

Constraints:

1 <= matchsticks.length <= 15
0 <= matchsticks[i] <= 109
 */


class Solution {

    // TC : O(4^N)
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;

        int perimeter = 0;
        for (int el : nums)  {
            perimeter += el;
        }

        if (perimeter % 4 != 0) return false;

        Arrays.sort(nums);
        int side = perimeter / 4;
        int[]  sides = new int[] {side, side, side, side};

        return makesquareHelper(nums, 0, sides);
    }

    private boolean makesquareHelper(int[] nums, int i, int[] sides) {
        if(i == nums.length) {

            if(sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0){
                return true;
            } else{
                return false;
            }
        }


        for (int j = 0; j < 4; j++) {
            if (nums[i] > sides[j]) continue;
            sides[j] -= nums[i];
            if (makesquareHelper(nums, i + 1, sides)) return true;
            sides[j] += nums[i];
        }

        return false;
    }
}