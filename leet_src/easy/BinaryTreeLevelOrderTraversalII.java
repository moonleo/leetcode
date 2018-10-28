package leet.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import norm.TreeNode;
/**
 * No.107 Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' 
 * values. (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {

	}
	
	Stack<List<TreeNode>> stack = new Stack<List<TreeNode>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(null == root) 
            return result;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        nextLevelNode(list);
        List<Integer> temp;
        while(!stack.isEmpty()) {
            temp = new ArrayList<Integer>();
            list = stack.pop();
            for(int i=0; i<list.size(); i++) {
                temp.add(list.get(i).val);
            }
            result.add(temp);
        }
        return result;
    }
    
    public void nextLevelNode(List<TreeNode> list) {
        if(null == list || 0 == list.size())
            return;
        stack.push(list);
        List<TreeNode> result = new ArrayList<TreeNode>();
        for(TreeNode node: list) {
            if(null != node.left) {
                result.add(node.left);
            }
            if(null != node.right) {
                result.add(node.right);
            }
        }
        nextLevelNode(result);
    }

}
