package leet.easy;

/**
 * No.104 Given a binary tree, find its maximum depth.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepthBinaryTree {
	public int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        return max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    
    int max(int a, int b) {
        return a > b ? a : b;
    }
}
