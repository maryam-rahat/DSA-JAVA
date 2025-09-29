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
    private TreeNode prev;
    public void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);
        
        prev.right = node;
        node.left = null;
        prev = node;

        inOrder(node.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode(0, null, root);
        prev = newRoot;

        inOrder(root);

        return newRoot.right;
    }
}