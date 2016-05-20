/**
 * 66. Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
**/

public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int digit; 
        Boolean overflow = false;
        
        while (i >= 0) {
            digit = digits[i] + 1;
            
            if (digit > 9) {
                overflow = true;
                digits[i] = 0;
                i--;
            } else {
                overflow = false;
                digits[i] = digit;
                break;
            }
        }
        // if array was too small, we need to return a new (bigger) array with a 1 in the msb
        if (overflow) {
            int newSigDig = digits.length + 1;
            int[] newDigits = new int[newSigDig];
            newDigits[0] = 1;
            for (int j = 1; j < newSigDig; j++) {
                newDigits[j] = digits[j-1];
            }
            return newDigits;
        }
        else
            return digits;
    }
}
