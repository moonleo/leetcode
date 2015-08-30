package leet.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import norm.ListNode;

/**
 * No.23 Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted 
 * list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(0 == lists.length)
			return null;
		//用优先队列存储链表结点
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new MyComparator());
        //各链表头结点入队
        for(int i=0; i<lists.length; i++) {
        	if(null != lists[i])
        		queue.add(lists[i]);
        }
        ListNode head = null, lastNode = null, currentNode;
        ListNode pollNode;
        while(!queue.isEmpty()) {
        	pollNode = queue.poll();
        	if(null == head) {
        		head = new ListNode(pollNode.val);
        		lastNode = head;
        	} 
        	//每次出队最小的元素并将链接到输出链表之后
        	else {
        		currentNode = new ListNode(pollNode.val);
        		lastNode.next = currentNode;
        		lastNode = currentNode;
        	}
        	if(null != pollNode.next)
        		queue.add(pollNode.next);
        }
        return head;
    }
	
	class MyComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			if(o1.val > o2.val) 
				return 1;
			else if(o1.val < o2.val)
				return -1;
			return 0;
		}
		
	}
}
