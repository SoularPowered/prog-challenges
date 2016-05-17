/* 198. House Robber
  You are a professional robber planning to rob houses along a street. 
  Each house has a certain amount of money stashed, the only constraint stopping you
  from robbing each of them is that adjacent houses have security system connected and
  it will automatically contact the police if two adjacent houses were broken into on 
  the same night.

  Given a list of non-negative integers representing the amount of money of each house,
  determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        int h = nums.length; // # of houses
        if (h == 0) return 0;
        if (h == 1) return nums[0];
        if (h == 2) return Math.max(nums[0], nums[1]);
        
        /* Dynamic programming solution. The basic idea is that we store the maximum that we
        could have stolen so far and check if it's better to have stolen from current house
        or the prior house + all of the ones before it that optimized our strategy before.
        */
        
        int[] dollars = new int[h]; // Store the most we could have robbed based on what we've seen so far
        
        for (int i = 0; i < h; i++) {
            if (i == 0) {
                // The most we can steal from the first house is whatever is there
                dollars[0] = nums[0];
            } else if (i == 1) {
                // steal from second house only if we can get more than the first house
                dollars[1] = Math.max(nums[0], nums[1]);
            } else {
                //  we steal from any other house only if our total 'haul' would be greater than what we
                // would have gotten by using a startegy that involved stealing from the preceding house
                // This is because we cannot steal from house i and also house i-1, so we pick whichever of the two
                // strategies is better
                dollars[i] = Math.max(nums[i] + dollars[i-2], dollars[i-1]);
            }
        }
        
        return dollars[h-1]; // at the end, we will have returned the amount we would have stolen from the last element of our array
    }
}
