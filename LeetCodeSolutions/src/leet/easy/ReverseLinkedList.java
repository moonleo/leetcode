package leet.easy;

import norm.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if(null == head || null == head.next) {
            return head;
        }
        ListNode p = head, q = p.next, r;
        p.next = null;
        while(q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}
