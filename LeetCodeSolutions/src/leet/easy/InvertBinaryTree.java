package leet.easy;

import norm.TreeNode;

/**
 * No.226 颠倒二叉树
 * 
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (null == root) {
			return null;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;
		// 交换左右子树
		root.left = right;
		root.right = left;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
