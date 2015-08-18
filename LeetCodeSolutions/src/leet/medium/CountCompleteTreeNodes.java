package leet.medium;

import norm.TreeNode;

/**
 * No.222 Count Complete Tree Nodes
 * Given a complete binary tree, count the number of nodes.
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if(null == root)
            return 0;
        //若最左叶子结点的深度等于最右叶子节点的深度，说明这是一棵满二叉树，可用公式计算
        //否则递归求解
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if(leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
	/**
	 * @param root 二叉树根节点
	 * @return 二叉树最左叶子结点的深度
	 */
    private int leftDepth(TreeNode root) {
        if(null == root) 
            return 0;
        int depth = 0;
        while(null != root) {
            root = root.left;
            depth ++;
        }
        return depth;
    }
    
    /**
     * @param root 二叉树根节点
     * @return 二叉树最右叶子结点的深度
     */
    private int rightDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int depth = 0;
        while(null != root) {
            root = root.right;
            depth ++;
        }
        return depth;
    }
}
