/*Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
* For example:
*     A -> 1
*     B -> 2
*     C -> 3
*     ...
*     Z -> 26
*     AA -> 27
*     AB -> 28 
*/


public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int result = 0, placeMult = 1;
        
        for (int i = len - 1; i >= 0; i--) {
            result = result + (toInt(s.charAt(i)) * placeMult);
            placeMult *= 26;
        }

        return result;
    }
    
    public int toInt(char c) {
        return c - 64;
    }
}
