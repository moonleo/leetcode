package leet.easy;

import norm.TreeNode;

/**
 * No.101 Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 */
public class SymmetricTree {

	public static void main(String[] args) {

	}
	
	public boolean isSymmetric(TreeNode root) {
        if(null == root)
            return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

}
