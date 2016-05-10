/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST. 
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).” 
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * 
 * 
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        Queue<TreeNode> pPath = new LinkedList<TreeNode>();
        Queue<TreeNode> qPath = new LinkedList<TreeNode>();
        boolean pReached = false, qReached = false;
        
        // Build path to p as a queue
        while (!pReached) {
            // Add current node to queue
            pPath.add(current);
            if (current.val == p.val)
                pReached = true;
            else if (p.val < current.val)
                current = current.left;
            else if (p.val > current.val)
                current = current.right;
        }
        current = root;
        // build path to q as a queue
        while (!qReached) {
            // Add current node to queue
            qPath.add(current);
            if (current.val == q.val)
                qReached = true;
            else if (q.val < current.val)
                current = current.left;
            else if (q.val > current.val)
                current = current.right;
        }
        
        // Empty both queues until nodes don't match. Given root is added to both queues ,we will always have at least one candidate
        TreeNode candidate = null, pNext = null, qNext = null;
        do {
            pNext = pPath.poll();
            qNext = qPath.poll();
            if (pNext != null && qNext != null)
                if (pNext == qNext)
                    candidate = pNext;
            else break;
        } while (pNext != null && qNext != null);
        
        return candidate;
    }
}
