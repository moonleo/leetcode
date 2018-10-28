package leet.medium;

import java.util.LinkedList;
import java.util.Queue;

import norm.TreeLinkNode;

/**
 * No.116 Populating Next Right Pointers in Each Node
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be 
 * set to NULL.
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * `You may only use constant extra space.
 * `You may assume that it is a perfect binary tree 
 *
 */
public class PopulatingNextRightPointersInEachNode {
	
	public void connect(TreeLinkNode root) {
        if(null == root) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();//保存遍历中的二叉树结点
        queue.offer(root);
        int currentLevelNum = 1;//当前层剩余未遍历的结点数
        int nextLevelNum = 0;//下一层的结点总数
        TreeLinkNode currentNode;//访问的当前结点  
        while(!queue.isEmpty()) {
        	currentNode = queue.poll();
        	//向队列中添加左右子树
        	if(null != currentNode.left) {
        		queue.offer(currentNode.left);
        		nextLevelNum ++;
        	}
        	if(null != currentNode.right) {
        		queue.offer(currentNode.right);
        		nextLevelNum ++;
        	}
        	currentLevelNum --;
        	//若当前层访问完毕，该结点next置为null
        	if(0 == currentLevelNum) {
        		currentNode.next = null;
        		currentLevelNum = nextLevelNum;
        		nextLevelNum = 0;
        	} 
        	//否则置为队列头结点
        	else {
        		currentNode.next = queue.peek();
        	}
        }
    }
	
}
