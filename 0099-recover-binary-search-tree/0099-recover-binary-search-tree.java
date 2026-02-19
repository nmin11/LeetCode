/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                checkSwap(cur);
                cur = cur.right;
            } else {
                TreeNode predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    predecessor.right = null;
                    checkSwap(cur);
                    cur = cur.right;
                }
            }
        }
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void checkSwap(TreeNode cur) {
        if (prev != null && prev.val > cur.val) {
            if (first == null) {
                first = prev;
            }

            second = cur;
        }

        prev = cur;
    }
}