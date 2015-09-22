package leet.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import norm.TreeNode;

/**
 * No.144 Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 */
public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {

	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(null == root) {
            return list;
        }        
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(p);
        while(!stack.isEmpty()) {
            p = stack.pop();
            list.add(p.val);
            if(p.right != null) {
                stack.push(p.right);
            }
            if(p.left != null) {
                stack.push(p.left);
            }
        }
        return list;
    }

}
