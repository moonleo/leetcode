package leet.medium;

import java.util.Stack;

import norm.TreeNode;

/**
 * No.230 Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth 
 * smallest element in it.
 */
public class KthSmallestElementInABST {
	
	public int kthSmallest(TreeNode root, int k) {
        travelInOrder(root, k);
        return result;
    }
	//递归方式
    int result = -1;//结果
    int count = 0;//计数
    public void travelInOrder(TreeNode root, int k) {
        if(null == root) {
            return ;
        }
        travelInOrder(root.left, k);
        count ++;
        if(count == k) {
            result = root.val;
        }
        travelInOrder(root.right, k);
    }
    
    //非递归方式
    public int travelNoRes(TreeNode root, int k) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode p = root;
    	TreeNode temp;
    	int count = 0;
    	while(null != p || !stack.isEmpty()) {
    		if(null != p) {
    			stack.push(p);
    			p = p.left;
    		} else {
    			temp = stack.pop();
    			count ++;
    			if(count == k) {
    				return temp.val;
    			}
    			p = p.right;
    		}
    	}
    	return -1;
    }

}
