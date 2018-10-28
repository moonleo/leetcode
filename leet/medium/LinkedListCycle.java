package leet.medium;

import norm.ListNode;

/**
 * No.141 Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 */
public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
        if(null == head)
            return false;
        ListNode p = head, q = head.next;
        while(null != p && null != q) {
            if(p == q) {
                return true;
            }
            p = p.next;
            if(q != null) {
                q = q.next;
            }
            if(q != null) {
                q = q.next;
            }
        }
        return false;
    }

}
