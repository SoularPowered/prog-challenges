/* 448. Find All Numbers Disappeared in an Array

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

(Not Implemented) - Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
*/

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] valueExists = new boolean[nums.length];
        
        for (int i = 0; i < valueExists.length; i++) {
            valueExists[i] = false;
        }
        
        for (int j = 0; j < nums.length; j++) {
            valueExists[nums[j]-1] = true;
        }
        
        List<Integer> solution = new ArrayList<Integer>();
        
        for (int k = 0; k < valueExists.length; k++) {
            if (valueExists[k] == false) {
                solution.add(k+1);
            }
        }
        
        return solution;
    }
}