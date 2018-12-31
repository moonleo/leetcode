/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      //给队列加一个虚拟的头结点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q;
        boolean flag = false;//使用一个标记位记录是否有重复元素
        while(p != null) {
            q = p.next;
            while(q != null && q.next != null
                 && q.val == q.next.val) {
                q = q.next;
                flag = true;
            }
            if(flag) {
              //如果前面有重复的元素，不移动p的位置，仅移动q的位置
                p.next = q.next;
                flag = false;
            } else {
              //如果前面没有重复的元素，移动p的位置
                p = q;
            }
        }

        return newHead.next;
    }
}
