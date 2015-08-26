package norm;

/**
 * Definition for singly linked list
 *
 */
public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public static ListNode array2List(int[] array) {
		ListNode head = new ListNode(array[0]);
		ListNode temp = head;
		for(int i=1; i<array.length; i++) {
			ListNode current = new ListNode(array[i]);
			temp.next = current;
			temp = current;
		}
		return head;
	}
	
	public static void display(ListNode head) {
		ListNode temp = head;
		if(null == temp) {
			System.out.println("null");
		}
		while(null != temp) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
}
