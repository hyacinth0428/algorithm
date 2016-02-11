package com.martin.tree;

import java.util.Stack;

public class VerifyPreOrderSerial {
	public static class Node {
		public String val;
		public int childCnt;
		public Node(String name) {
			this.val = name;
			this.childCnt = 0;
		}
	}
	
	public static boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length() == 0) return false;
        String[] data = preorder.split(",");
 		return checkUsingStack(data);
    }
	
	public static boolean checkUsingStack(String[] data) {
		Stack<Node> stk = new Stack<Node>();
		
		for(int i=0;i<data.length;i++) {
			if(!data[i].equals("#")) {
				stk.push(new Node(data[i]));
			}else{
				if(stk.size()==0) return false;
				stk.peek().childCnt++;
				while(!stk.empty()) {
					if(stk.peek().childCnt == 2) {
						stk.pop();
						if(!stk.isEmpty()) {
							stk.peek().childCnt ++;
						}
					}else break;
				}
			}
		}
		
		return stk.isEmpty();
	}
	
	public static boolean checkIfPre(String[] data, int start, int end) {
		if(start > end ) return false;
		if(data[start].equals("#")){
			if(end - start == 0) return true;
			else return false;
		}else{
			//in here we have real nodes
			if(end - start < 2) return false;
			for(int i=start+1;i<end;i++) {
				if(data[i].equals("#")) {
					if(checkIfPre(data,start+1,i) && checkIfPre(data,i+1,end))
						return true;
				}
			}
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String waha = "9,9,9,9,9,9,9,9,#,9,#,#,9,#,9,#,#,#,9,9,#,9,#,#,9,#,9,#,#,9,9,9,#,9,#,#,9,#,#,9,#,#,9,9,9,9,9,#,#,#,9,9,#,9,9,9,9,#,#,#,#,9,#,9,9,#,#,#,9,#,#,9,9,9,#,#,9,9,#,#,9,9,#,#,#,9,#,9,9,9,9,#,#,#,#,9,#,#,9,9,9,#,9,#,#,9,9,9,#,#,9,#,#,9,9,#,9,#,9,9,#,#,#,9,#,#,9,9,#,9,#,#,9,#,#,9,9,9,#,#,#,9,9,9,9,#,9,#,#,9,#,#,9,9,#,9,#,#,9,9,#,#,9,#,#,#,9,9,9,#,#,9,#,#,9,9,9,#,#,9,9,#,#,#,9,#,9,#,9,#,#";
		boolean res = isValidSerialization(waha);
		System.out.println();
	}

}
