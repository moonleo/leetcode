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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            TreeNode lastR = left;
            while (lastR.right != null) {
                lastR = lastR.right;
            }
            lastR.right = right;
            root.right = left;
            root.left = null;
        }
    }
}
