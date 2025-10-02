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
    ArrayList<TreeNode> res = new ArrayList<>();
    public void inOrder(TreeNode node){
        if(node==null) return;

        inOrder(node.left);
        res.add(node);
        inOrder(node.right);
        return ;
    }
    public void recoverTree(TreeNode root) {
        inOrder(root);
        TreeNode first = null, second = null;
        for(int i = 0; i < res.size()-1; i++){
            if (res.get(i).val > res.get(i + 1).val) {
                if (first == null) {
                    first = res.get(i);  
                }
                second = res.get(i + 1);  
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}