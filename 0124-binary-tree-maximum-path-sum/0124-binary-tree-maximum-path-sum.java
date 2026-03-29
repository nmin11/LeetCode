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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxSum;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(maxPathDown(node.left), 0);
        int right = Math.max(maxPathDown(node.right), 0);
        maxSum = Math.max(maxSum, left + node.val + right);

        return node.val + Math.max(left, right);
    }
}