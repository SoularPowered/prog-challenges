/* 
349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection. 

Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2]. 

Note:

•Each element in the result must be unique.
•The result can be in any order.

*/

public class Solution {

    /* This is a hot mess of a solution but it works, I suspect some tools I'm overlooking to complete this task */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1set = new HashSet<Integer>();
        HashSet<Integer> nums2set = new HashSet<Integer>();
        
        // First we remove all of the duplicates from the arrays by adding to sets
        for (int val1 : nums1) {
            nums1set.add(val1);
        }
        for (int val2 : nums2) {
            nums2set.add(val2);
        }

        nums1set.retainAll(nums2set);     
        
        Integer[] resultI = new Integer[nums1set.size()];
        int[] result = new int[nums1set.size()];
        
        nums1set.toArray(resultI);
        for (int i = 0; i < result.length; i++) {
            result[i] = resultI[i];
        }
        return result;
    }
}
