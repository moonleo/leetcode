package leet.easy;

import norm.ListNode;

/**
 * No.19 Remove Nth Node From End of List 
 * Given a linked list, remove the nth node from the end of 
 * list and return its head.
 * Note:
 * ·Given n will always be valid. 
 * ·Try to do this in one pass. 
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(null == head)
            return null;
		//node移动到正数第n个结点上
        ListNode node = head;
        for(int i = 0; i < n-1; i ++) {
            if(null != node)
                node = node.next;
        }
        //n超过链表长度，或者链表只有一个结点且需要删除
        if(null == node) 
            return null;
        //要删除结点的前一个结点
        ListNode slowPointer = null;
        //要删除的结点
        ListNode fastPointer = head;
        //可能删除头结点，记录新的头结点
        ListNode newHead = head;
        //三个结点同时移动
        while(null != node.next) {
            node = node.next;
            fastPointer = fastPointer.next;
            if(null == slowPointer) {
                slowPointer = head;
            } else {
                slowPointer = slowPointer.next;
            }
        }
        //要删除的结点为头结点
        if(null == slowPointer)
            newHead = fastPointer.next;
        else {
            slowPointer.next = fastPointer.next;
            fastPointer.next = null;
        }
        return newHead;
    }
}
