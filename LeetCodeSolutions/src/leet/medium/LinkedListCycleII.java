package leet.medium;

import norm.ListNode;

/**
 * No.142 Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 */
public class LinkedListCycleII {

	public static void main(String[] args) {

	}
	
	public ListNode detectCycle(ListNode head) {
        ListNode p = hasCircle(head);
        if(null != p) {
            int count = 1;
            ListNode q = p.next;
            while(q != p) {
                q = q.next;
                count ++;
            }
            ListNode m = head;
            while(count > 0) {
                m = m.next;
                count --;
            }
            ListNode n = head;
            while(n != m) {
                n = n.next;
                m = m.next;
            }
            return n;
        }
        return null;
    }
    
    private ListNode hasCircle(ListNode head) {
        if(null == head) {
            return null;
        }
        ListNode p = head, q = head.next;
        while(q != null) {
            if(p == q) {
                return p;
            }
            p = p.next;
            if(q != null) {
                q = q.next;
            }
            if(q != null) {
                q = q.next;
            }
        }
        return null;
    }

}
