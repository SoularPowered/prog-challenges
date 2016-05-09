/*
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false. 
 */

public class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen != tLen) return false;
        
        int[] sChars = new int[26], tChars = new int[26];
        for (int i = 0; i < sLen; i++) {
            int sAsciiVal = s.charAt(i) - 97;
            sChars[sAsciiVal]++;
            int tAsciiVal = t.charAt(i) - 97;
            tChars[tAsciiVal]++;
        }
        return Arrays.equals(sChars, tChars);
    }
}
