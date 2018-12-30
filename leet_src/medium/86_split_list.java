/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode preHead = null;
        ListNode pre = null;
        ListNode postHead = null;
        ListNode post = null;
        ListNode p = head;
        while(p != null) {
            if(p.val < x) {
                if(preHead == null) {
                    preHead = p;
                    pre = preHead;
                    p = p.next;
                    pre.next = null;
                } else {
                    pre.next = p;
                    p = p.next;
                    pre = pre.next;
                    pre.next = null;
                }
            } else {
                if(postHead == null) {
                    postHead = p;
                    post = postHead;
                    p = p.next;
                    post.next = null;
                } else {
                    post.next = p;
                    p = p.next;
                    post = post.next;
                    post.next = null;
                }
            }
        }
        if(pre != null) {
            pre.next = postHead;
        } else {
            return postHead;
        }
        return preHead;
    }
}
