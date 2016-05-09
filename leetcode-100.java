/**
 * 100. Same Tree
 * Given two binary trees, write a funciton to check if they are equal or not.
 * Two binary trees area considered equal if they are structurally identical and the nodes have the same value.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base cases: both nodes are null (true) or they are not both null (false)
        if (p == null && q == null)
            return true;
        if ( (p == null && q != null) || (p != null && q == null) )
            return false;
        // now compare this node since we know they are both not null
        if (p.val == q.val)
            return ( isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        else
            return false;
    }
}
