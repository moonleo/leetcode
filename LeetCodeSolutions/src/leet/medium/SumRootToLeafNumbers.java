package leet.medium;

import java.util.ArrayList;
import java.util.List;

import norm.TreeNode;

/**
 * No.129 Sum Root to Leaf Numbers
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number. 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123. 
 * Find the total sum of all root-to-leaf numbers.
 */
public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		node0.left = node1;
		node0.right = node2;
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		node1.left = node3;
		node1.right = node4;
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		node2.left = node5;
		node2.right = node6;
		System.out.println(new SumRootToLeafNumbers().sumNumbers(node0));
	}
	
	public int sumNumbers(TreeNode root) {
        if(null == root) {
            return 0;
        }
        path2Leaf(root);
        return sum;
    }
    int sum = 0;
    List<TreeNode> list = new ArrayList<TreeNode>();
    public void path2Leaf(TreeNode root) {
        list.add(root);
        if(null == root.left && null == root.right) {
            sum += list2Integer(list);
            return ;
        }
        if(null != root.left) {
            path2Leaf(root.left);
        }
        list.remove(list.size()-1);
        if(null != root.right) {
            path2Leaf(root.right);
        }
        list.remove(list.size()-1);
    }
    
    private int list2Integer(List<TreeNode> list) {
        int degree = 1;
        int sum = 0;
        for(int i=list.size()-1; i>=0; i--) {
            TreeNode node = list.get(i);
            sum += node.val*degree;
            degree *= 10;
        }
        return sum;
    }

}
