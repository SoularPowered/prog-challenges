/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric: 
    1
   / \
  2   2
 / \ / \
3  4 4  3



But the following is not:

    1
   / \
  2   2
   \   \
   3    3

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Use recursive helper
        return isSymmetricRec(root, root);
    }
    
    public boolean isSymmetricRec(TreeNode n1, TreeNode n2) {
        // If the subtrees are both null, return true
        if (n1 == null && n2 == null) return true;
        
        // Return false if only one node is null (because we know they are not both null by prior check)
        if (n1 == null || n2 == null) return false;
        
        // return true if and only if this node's values are true and all of the left subtree
        // values are the same as the right subtree values (checked recursivel)
        return (n1.val == n2.val) && isSymmetricRec(n1.left, n2.right) && isSymmetricRec(n1.right, n2.left);
    }
}
