/**
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced. 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the 
 * two subtrees of every node never differ by more than 1.
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Recursive solution. If the height of the subtrees differs by more than 1 for any node,
        // then the result is false.
        
        // Base case 1
        if (root == null) 
            return true;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        // Base case 2
        if (Math.abs(leftHeight-rightHeight) > 1) 
            return false;
        
        // Recursive case
        return (isBalanced(root.left) && isBalanced(root.right));
        
    }
    
    public int getHeight(TreeNode root) {
        // Recursive. 
        
        // Base case:
        if (root == null) 
            return 0;
            
        // Recursive case:
        else
            return (Math.max(getHeight(root.left), getHeight(root.right))) + 1;
    }
}
