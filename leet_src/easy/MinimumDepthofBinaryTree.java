package leet.easy;

import norm.TreeNode;

/**
 * No.111 Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth. The minimum depth is the number 
 * of nodes along the shortest path from the root node down to the nearest leaf 
 * node.
 */
public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {

	}
	
	public int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left == null) {
            return minDepth(root.right) + 1;
        }
        if(root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }

}
