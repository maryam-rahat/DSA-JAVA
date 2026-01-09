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
    private static class DepthNode {
        int depth;
        TreeNode node;

        DepthNode(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    private DepthNode dfs(TreeNode node){
        if (node == null) {
            return new DepthNode(0, null);
        }

        DepthNode left = dfs(node.left);
        DepthNode right = dfs(node.right);

        if (left.depth == right.depth) {
            return new DepthNode(left.depth + 1, node);
        }
        else if (left.depth > right.depth) {
            return new DepthNode(left.depth + 1, left.node);
        }
        else {
            return new DepthNode(right.depth + 1, right.node);
        }
    }

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root).node;
        }
}