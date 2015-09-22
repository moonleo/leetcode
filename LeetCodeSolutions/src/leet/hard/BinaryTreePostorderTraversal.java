package leet.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import norm.TreeNode;

/**
 * No.145 Binary Tree Postorder Traversal
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {

	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(null == root) {
            return list;
        }
        stack.push(cur);
        while(!stack.isEmpty()) {
            cur = stack.peek();
            if((cur.left == null && cur.right == null)
            ||(pre != null &&(cur.left == pre || cur.right == pre))) {
                list.add(cur.val);
                pre = cur;
                stack.pop();
            } else {
                if(cur.right != null)
                    stack.push(cur.right);
                if(cur.left != null) 
                    stack.push(cur.left);
            }
        }
        return list;
    }

}
