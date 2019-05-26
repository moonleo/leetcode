/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int bottomLeft = 0;
        queue.add(root);
        TreeNode node;
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        boolean first = true;
        while(!queue.isEmpty() || !nextLevel.isEmpty()) {
            if(queue.isEmpty()) {
                queue.addAll(nextLevel);
                nextLevel.clear();
                first = true;
                continue;
            }
            node = queue.remove();
            if(first) {
                bottomLeft = node.val;
                first = false;
            }
            if(node.left != null) {
                nextLevel.add(node.left);
            }
            if(node.right != null) {
                nextLevel.add(node.right);
            }
        }
        return bottomLeft;
    }
}
