package com.martin.lc;

public class PalindromeList {
	public static class ListNode{
		public int val;
		public ListNode next;
		public ListNode(int x){val=x;}
	}
	public static ListNode reverse(ListNode h){
        ListNode dummy = new ListNode(-1);
        ListNode head = h;
        dummy.next = head;
        head = dummy;
        ListNode cur = head.next;
        ListNode next = cur.next;
        while(next!=null){
            cur.next = next.next;
            next.next=  head.next;
            head.next = next;
            next = cur.next;
        }
        return dummy.next;
    }
    
    public static int getLen(ListNode head){
        int cnt = 0;
        while(head!=null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        int start = 0;
        int end = getLen(head) - 1;
        ListNode h = head;
        ListNode rRunner = reverse(h);
        ListNode runner = head;
        
        while(start < end){
            if(runner.val != rRunner.val) return false;
            runner = runner.next;
            rRunner = rRunner.next;
            start++;
            end--;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		isPalindrome(n1);
	}

}
