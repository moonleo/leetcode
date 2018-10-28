package leet.easy;

import norm.TreeNode;

/**
 * No.110 Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced. For this problem, 
 * a height-balanced binary tree is defined as a binary tree in which the 
 * depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		
	}
	
	public boolean isBalanced(TreeNode root) {
        if(null == root) {
            return true;
        }
        if(treeDepth(root) != -1) {
            return true;
        }
        return false;
    }
    
    public int treeDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int leftDepth = treeDepth(root.left);
        if(leftDepth == -1) {
            return -1;
        }
        int rightDepth = treeDepth(root.right);
        if(rightDepth == -1) {
            return -1;
        }
        if(Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
