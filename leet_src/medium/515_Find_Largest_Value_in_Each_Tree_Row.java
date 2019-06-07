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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        } else {
            return result;
        }
        List<TreeNode> tmp = new ArrayList<TreeNode>();
        int max;
        while (!queue.isEmpty()) {
            tmp.clear();
            max = Integer.MIN_VALUE;
            while(!queue.isEmpty()) {
                tmp.add(queue.poll());
            }
            for(TreeNode node: tmp) {
                max = max > node.val ? max : node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
