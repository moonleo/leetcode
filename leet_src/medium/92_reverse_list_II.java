/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode a = new ListNode(0);
        a.next = head;
        ListNode p = a;
        ListNode newHead = null;
        ListNode newReal = null;
        ListNode q;
        int count = 0;
        while(p != null) {
            count ++;
            if(count < m) {
                p = p.next;
            } else if(count == m) {
                newHead = p.next;
                newReal = newHead;
            } else if(count > m && count <= n) {
                q = newReal.next;
                newReal.next = q.next;
                p.next = q;
                q.next = newHead;
                newHead = q;
            } else if(count > n) {
                break;
            }

        }

        return a.next;
    }
}
