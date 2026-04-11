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
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        if (root == null) return result;

        dfs(root, new ArrayList<>(), 0, targetSum);

        return result;
    }

    private void dfs(TreeNode node, List<Integer> curPath, int curSum, int target) {
        curPath.add(node.val);
        curSum += node.val;

        boolean isLeaf = node.left == null && node.right == null;
        if (isLeaf && curSum == target) {
            result.add(new ArrayList<>(curPath));
        }

        if (node.left != null) {
            dfs(node.left, curPath, curSum, target);
        }

        if (node.right != null) {
            dfs(node.right, curPath, curSum, target);
        }

        curPath.remove(curPath.size() - 1);
    }
}