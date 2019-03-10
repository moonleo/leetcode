/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode sortHead = new ListNode(Integer.MIN_VALUE);
        sortHead.next = head;
        ListNode sortTail = head;
        ListNode unsortHead = head.next;
        ListNode removed;
        while(unsortHead != null) {
            if(unsortHead.val > sortTail.val) {
                sortTail = sortTail.next;
                unsortHead = unsortHead.next;
                continue;
            }
            removed = unsortHead;

            unsortHead = unsortHead.next;
            sortTail.next = unsortHead;

            ListNode p = sortHead;
            while(p != sortTail) {
                if(removed.val > p.next.val) {
                    p = p.next;
                } else {
                    removed.next = p.next;
                    p.next = removed;
                    break;
                }
            }
        }

        return sortHead.next;
    }
}
