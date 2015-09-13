package leet.easy;

import norm.ListNode;

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
        ListNode p = head, q;
        //找到新链表的头结点
        while(null !=p && p.val == val) {
            p = p.next;
        }
        if(p == null) {
            return null;
        }
        head = p;
        while(p != null) {
            q = p.next;
            while(null != q && val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
    }

}
