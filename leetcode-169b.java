/*
 * 169. Majority Element
* 
* Given an array of size n, find the majority element. 
* The majority element is the element that appears more than ⌊ n/2 ⌋ times.
* 
* You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] nums) {
        // if an element occurs more than "half the time" then it will occupy
        // at least half the elements. If we take the element in the dead center
        // of a sorted array, we would know that it's the majority element
        // based on the assumptions this challenge makes (that there is one present, specifically)
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
