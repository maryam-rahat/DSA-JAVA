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
    private int[] nums;

    public TreeNode buildTree(int left, int right){
        if(left>right) return null;

        int max = left;
        for(int i = left ; i <= right; i++){
            if(nums[i] > nums[max]){
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = buildTree(left, max -1);
        root.right = buildTree(max+1, right);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return buildTree(0, nums.length - 1);
    }
}