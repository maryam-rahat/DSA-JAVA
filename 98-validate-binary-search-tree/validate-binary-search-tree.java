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
    public ArrayList<Integer> inOrder(TreeNode node, ArrayList<Integer> res){
        if(node == null) return res;

        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
        return res;
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);

        for(int i = 1; i < res.size(); i++){
            if(res.get(i-1) >= res.get(i)) return false;
        }
        return true;
    }
}