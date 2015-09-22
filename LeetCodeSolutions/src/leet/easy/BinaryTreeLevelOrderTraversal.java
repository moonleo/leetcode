package leet.easy;

import java.util.ArrayList;
import java.util.List;

import norm.TreeNode;

/**
 * No.102 Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
	
	List<List<Integer>> allList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null != root) {
            List<TreeNode> level = new ArrayList<TreeNode>();
            level.add(root);
            levelOrder(level);
        }
        return allList;
    }
    
    public void levelOrder(List<TreeNode> list) {
        if(0 == list.size())
            return ;
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> next = new ArrayList<TreeNode>();
        for(TreeNode node: list) {
            result.add(node.val);
            if(null != node.left) {
                next.add(node.left);
            }
            if(null != node.right) {
                next.add(node.right);
            }
        }
        allList.add(result);
        levelOrder(next);
    }
	
	

}
