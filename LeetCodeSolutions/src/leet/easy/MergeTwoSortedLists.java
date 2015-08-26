package leet.easy;

import norm.ListNode;

/**
 * No.21 Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 *
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1 && null == l2) 
            return null;
        if(null == l1)
            return l2;
        if(null == l2)
            return l1;
        ListNode r1 = l1, r2 = l2;
        ListNode head;//新链表的头结点
        boolean inL1;//记录当前结点是否在链表1中
        if(r1.val < r2.val) {
            head = r1;
            inL1 = true;
        } else {
            head = r2;
            inL1 = false;
        }
        ListNode currentNode = null;
        while(null != r1 && null != r2) {
            if(r1.val < r2.val) {
                if(inL1) {
                    if(null == currentNode) {
                        currentNode = head;
                    } else {
                        currentNode = currentNode.next;
                    }
                } else {
                    currentNode.next = r1;
                    currentNode = currentNode.next;
                    inL1 = true;
                }
                r1 = r1.next;
            } else {
                if(inL1) {
                    currentNode.next = r2;
                    currentNode = currentNode.next;
                    inL1 = false;
                } else {
                    if(null == currentNode) {
                        currentNode = head;
                    } else {
                        currentNode = currentNode.next;
                    }
                }
                r2 = r2.next;
            }
        }
        if(null != r2 && inL1) {
        	currentNode.next = r2;
        }
        if(null != r1 && !inL1) {
        	currentNode.next = r1;
        }
        return head;
    }
	
	//递归解法
	public void mergeTwoLists2(ListNode l1, ListNode l2) {
		
	}
	
	public static void main(String[] args) {
		ListNode l1 = ListNode.array2List(new int[]{1, 2, 7});
		ListNode l2 = ListNode.array2List(new int[]{3, 5, 9});
		ListNode head = new MergeTwoSortedLists().mergeTwoLists(l2, l1);
		ListNode.display(head);
	}
}
