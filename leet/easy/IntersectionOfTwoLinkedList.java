package leet.easy;

import norm.ListNode;

/**
 * No.160 Intersection Of Two Linked List
 * Write a program to find the node at which the intersection of two singly 
 * linked lists begins.
 */
public class IntersectionOfTwoLinkedList {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB) {
            return null;
        }
        int lengthA = listLength(headA);
        int lengthB = listLength(headB);
        int diff = Math.abs(lengthA - lengthB);
        ListNode p = lengthA > lengthB ? headA : headB;
        ListNode q = lengthA > lengthB ? headB : headA;
        while(diff > 0 && p != null) {
            p = p.next;
            diff --;
        }
        while(p != null && q != null) {
            if(q == p) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
    
    private int listLength(ListNode head) {
        ListNode p = head;
        int length = 0;
        while(p != null) {
            p = p.next;
            length ++;
        }
        return length;
    }

}
