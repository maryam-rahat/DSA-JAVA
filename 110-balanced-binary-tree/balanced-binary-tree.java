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
    static int height(TreeNode root){
        if (root == null) return 0;

        return (1 + Math.max(height(root.right), height(root.left)));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int rightTree = height(root.right);
        int leftTree = height(root.left);

        if(Math.abs(rightTree-leftTree) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}