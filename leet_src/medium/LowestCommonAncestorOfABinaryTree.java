package leet.medium;

import java.util.ArrayList;
import java.util.List;

import norm.TreeNode;

/**
 * No.236 Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes 
 * in the tree. According to the definition of LCA on Wikipedia: “The lowest 
 * common ancestor is defined between two nodes v and w as the lowest node in T 
 * that has both v and w as descendants (where we allow a node to be a descendant 
 * of itself).” 
 *
 */
public class LowestCommonAncestorOfABinaryTree {
	
	boolean find = false;
	
	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node3.left = node5;
		node3.right = node1;
		node5.left = node6;
		node5.right = node2;
		node2.left = node7;
		node2.right = node4;
		node1.left = node0;
		node1.right = node8;
		node8.right = node0;
		System.out.println(new LowestCommonAncestorOfABinaryTree()
		.lowestCommonAncestor(node1, node0, node1).val);
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        pathToNode(root, p, list1);
        
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        find = false;
        pathToNode(root, q, list2);
        int i=-1, j=-1;
        while(i+1 < list1.size() && j+1 < list2.size()) {
        	if(list1.get(i+1).val != list2.get(j+1).val) {
        		return list1.get(i);
        	}
        	i ++;
        	j ++;
        }
        if(i == list1.size()-1) {
        	return list1.get(i);
        } 
        if(j == list2.size()-1) {
        	return list2.get(j);
        }
        return null;
    }
    
    public void pathToNode(TreeNode root, TreeNode p, List<TreeNode> path) {
        if(null == root || find) {
            return ;
        }
        path.add(root);
        if(root == p) {
        	find = true;
            return ;
        }
        if(null != root.left) {
            pathToNode(root.left, p, path);
        } 
        if(null != root.right && !find) {
            pathToNode(root.right, p, path);
        }
        if(!find) {
        	path.remove(root);
        }
    }
}
