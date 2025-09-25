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
    private int currentCount = 0, maxCount = 0;
    private Integer prev = null;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null)
            return;

        inorderTraversal(node.left);

        if (prev != null && node.val == prev) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }

        prev = node.val;

        inorderTraversal(node.right);
    }
}