class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        boolean leftToRight = true;

        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            LinkedList<Integer> row = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodesQueue.poll();

                if (leftToRight) {
                    row.addLast(node.val);   // normal order
                } else {
                    row.addFirst(node.val);  // reverse order
                }

                if (node.left != null) nodesQueue.add(node.left);
                if (node.right != null) nodesQueue.add(node.right);
            }

            leftToRight = !leftToRight;
            result.add(row);
        }
        return result;
    }
}
