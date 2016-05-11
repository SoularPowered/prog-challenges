/*
70. Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top
*/

public class Solution {
    public int climbStairs(int n) {
        // This is exactly a fibonacci sequence
        // Using recursion or calling climbStairs(n-1) + climbStairs(n-2) is too slow
        n++; // Because the first two n for fib
        if(n <= 0) return 0;
        if(n > 0 && n < 3) return 1;
        
        int result = 0;
        int preOldResult = 1;
        int oldResult = 1;
        
        
        for (int i=2;i<n;i++) { 
            result = preOldResult + oldResult;
            preOldResult = oldResult;
            oldResult = result;
        }
        
        return result;
        /* 
        This can be thought of a few ways, but ultimately, this is fibonnaci sequence:
        # steps -> # of ways : samples
        0 -> 1 way : 1
        1 -> 1 way  : 1
        2 -> 2 ways : 1+1, 2
        3 -> 3 ways : 1+1+1, 2+1, 1+2
        4 -> 5 ways : 1+1+1+1, 2+1+1, 1+2+1, 1+1+2, 2+2
        5 -> 8 ways : 1+1+1+1+1, 2+1+1+1, 1+2+1+1, 1+1+2+1, 1+1+1+2, 2+2+1, 2+1+2, 1+2+2
        6 -> 13: 
            1+1+1+1+1+1, 
            2+1+1+1+1, 1+2+1+1+1, 1+1+2+1+1, 1+1+1+2+1, 1+1+1+1+2, 
            2+2+1+1, 2+1+2+1, 2+1+1+2, 1+2+2+1 1+2+1+2, 1+1+2+2,
            2+2+2
        7 -> 21 ways :
            1+1+1+1+1+1+1,  1 way to put 0 #2's into the 7 holes
            2+1+1+1+1+1, 6 ways to put 1 #2 into 6 holes
            , 10 ways ways to put 2 #2 5 holes
            4 ways to put 3 #2's into 4 holes
        */
    }
}
