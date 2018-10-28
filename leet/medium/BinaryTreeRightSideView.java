package leet.medium;

import java.util.ArrayList;
import java.util.List;

import norm.TreeNode;

/**
 * No.199 Binary Tree Right Side View
 * Given a binary tree, imagine yourself standing on the right side 
 * of it, return the values of the nodes you can see ordered from top 
 * to bottom.
 */
public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> rightSideView(TreeNode root) {
        if(null == root) {
            return result;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        travelByLevel(list);
        return result;
    }
    
    List<Integer> result = new ArrayList<Integer>();
    private void travelByLevel(List<TreeNode> list) {
        if(0 == list.size()) {
            return ;
        }
        result.add(list.get(list.size()-1).val);
        List<TreeNode> next = new ArrayList<TreeNode>();
        for(TreeNode node: list) {
            if(null != node.left) {
                next.add(node.left);
            }
            if(null != node.right) {
                next.add(node.right);
            }
        }
        travelByLevel(next);
    }

}
