/**
 * Leetcode # 104 Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth. 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        // Base case: tree is null, add nothing to depth
        if (root == null)
            return 0;
        // Recursively return 1 + max of left or right subtree
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
