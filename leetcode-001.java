public class Solution {
  public int[] twoSum(int[] nums, int target) 
  {        
    int i,j;        
    int[] result = new int[2];                
      for (i = 0; i < nums.length - 1; i++) {            
        int target2 = target - nums[i];            
        for (j = i + 1; j < nums.length; j++) {                
          if (nums[j] == target2) {                    
            result[0] = i; result[1] = j;                
          }            
        }        
      }                
    return result;    
  }
}
