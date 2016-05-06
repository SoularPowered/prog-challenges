/* 283. Move Zeroes
  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
  For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]. 
  Note:
    1.You must do this in-place without making a copy of the array.
    2.Minimize the total number of operations. 
  */

public class Solution {
    public void moveZeroes(int[] nums) {
        int next = 0; // next position to insert a non-zero value into
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[next++] = nums[i];
        }
        
        // fill in the end of the array with 0's
        while (next < nums.length)
            nums[next++] = 0;
    }
}
