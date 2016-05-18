/*
189. Rotate Array
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        // Naive / brute-force solution: copy the elements to a new array using
        // shifted indices and modulus operator, then copy them back into original array and free our new array
        int[] shift = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            k %= nums.length;
            shift[k] = nums[i];
            k++;
        }
        
        // copy solution back into array
        for (int j = 0; j < nums.length; j++) {
            nums[j] = shift[j];
        }
    }
}
