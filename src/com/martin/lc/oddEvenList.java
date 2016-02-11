package com.martin.lc;

public class oddEvenList {
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int value) {
			this.val = value;
			this.next = null;
		}
	}
	
	public ListNode oddEvenList(ListNode head) {
		if(head==null || head.next == null) return head;
		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-1);
		ListNode h1  = head;
		ListNode h2 = head.next;
		dummy1.next = h1;
		dummy2.next = h2;
		
		while(h1.next !=null && h2.next !=null ){
			h1.next = h1.next.next;
			if(h1.next!=null) h1 = h1.next;
			
			h2.next = h2.next.next;
			h2 = h2.next;
		}
		
		h1.next = dummy2.next;
		return dummy1.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
