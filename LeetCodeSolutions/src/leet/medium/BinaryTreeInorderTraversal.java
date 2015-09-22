package leet.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import norm.TreeNode;

/**
 * No.94 Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {

	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<Integer>();
        if(null == root) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }

}
