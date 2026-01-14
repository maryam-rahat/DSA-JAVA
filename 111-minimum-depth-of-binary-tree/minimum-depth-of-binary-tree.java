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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int depth = 1;
        Queue<TreeNode> q= new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            // q.poll(current);
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if(current.left == null && current.right == null){
                    return depth;
                }
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }

            }
            depth++;
        }
        return depth;
    }
}