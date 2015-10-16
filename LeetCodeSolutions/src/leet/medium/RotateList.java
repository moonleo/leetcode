package leet.medium;

import norm.ListNode;

/**
 * No.61 Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative. 
 * For example: 
 * Given 1->2->3->4->5->NULL and k = 2, 
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(null == head || head.next == null || k == 0) {
            return head;
        }
        int length = listLength(head);
        if(k % length == 0) {
            return head;
        }
        k = k % length;
        ListNode q = head, r;
        int count = length - k - 1;
        while(count > 0) {
            q = q.next;
            count --;
        }
        r = q.next;
        q.next = null;
        ListNode newHead = r;
        while(r.next!=null) {
            r = r.next;
        }
        r.next = head;
        return newHead;
    }
    
    private int listLength(ListNode head) {
        if(null == head) {
            return 0;
        }
        int count = 0;
        while(head != null) {
            head = head.next;
            count ++;
        }
        return count;
    }

}
