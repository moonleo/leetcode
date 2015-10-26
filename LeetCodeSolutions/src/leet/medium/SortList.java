package leet.medium;

import norm.ListNode;

/**
 * No.148 Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {

	public static void main(String[] args) {
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n2.next = n3;
		n3.next = n4; 
		n4.next = n1;
		n1.next = n0;
		
		ListNode p = new SortList().sortList(n2);
		while(p != null) {
			System.out.print(p.val+" ");
			p = p.next;
		}
	}
	
	public ListNode sortList(ListNode head) {
        if(null == head || null == head.next) {
            return head;
        }
        return sortList(head, null);
    }
    
	private ListNode sortList(ListNode head, ListNode tail) {
		if(head == tail) {
			return head;
		}
		ListNode p = head, q = head;
        while(q != tail) {
        	if(tail != q.next && tail != q.next.next) {
        		q = q.next.next;
        		p = p.next;
        	} else 
        		q = q.next;
        }
        q = p.next;
        p.next = null;
        return mergeList(sortList(head, p), sortList(q, tail));
	}
    
    
    private ListNode mergeList(ListNode l1, ListNode l2) {
    	if(null == l1) {
    		return l2;
    	} else if(null == l2) {
    		return l1;
    	} else {
    		ListNode newHead = null;
    		ListNode r = l1;
    		ListNode s = l2;
    		ListNode p = null;
    		while(null != r && null != s) {
    			if(r.val < s.val) {
    				if(null == newHead) {
    					newHead = r;
    					r = r.next;
    					p = newHead;
    				} else {
    					p.next = r;
    					r = r.next;
    					p = p.next;
    				}
    			} else {
    				if(null == newHead) {
    					newHead = s;
    					s = s.next;
    					p = newHead;
    				} else {
    					p.next = s;
    					s = s.next;
    					p = p.next;
    				}
    			}
    			p.next = null;
    		}
    		/*if(null != r) {
    			p.next = r;
    		} else if(null != s) {
    			p.next = s;
    		}*/
    		p.next = r == null ? s: r;
    		return newHead;
    	}
    }

}
