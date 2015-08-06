package leet.medium;

import norm.ListNode;

/**
 * No.24 Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify 
 * the values in the list, only nodes itself can be changed.
 * 
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(null == head || null == head.next)
            return head;
        ListNode p = head, q = head.next;
        p.next = q.next;
        q.next = p;
        head = q;
        swapRecur(p);
        return head;
    }
    /**
     * 递归调换两个结点
     * @param link
     */
    public void swapRecur(ListNode link) {
        if(null == link.next || null == link.next.next)
            return;
        ListNode p = link.next, q = p.next;
        p.next = q.next;
        q.next = p;
        link.next = q;
        swapRecur(p);
    }
}
