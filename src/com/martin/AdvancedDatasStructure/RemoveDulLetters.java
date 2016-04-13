package com.martin.AdvancedDatasStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDulLetters {
	
	public static String removeDuplicateLetters(String s) {
		if(s == null || s.length() <2 ) return s;
		//BuildHashMap
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0; i<s.length();i++) {
			char curChar = s.charAt(i);
			if(map.containsKey(curChar)){
				map.put(curChar, map.get(curChar)+1);
			}else{
				map.put(curChar,1);
			}
		}
		
		Stack<Character> stk = new Stack<Character>();
		HashSet<Character> store = new HashSet<Character>();
		for(int i=0;i<s.length();i++) {
			char curChar = s.charAt(i);
			map.put(curChar,map.get(curChar)-1);
			if(stk.isEmpty()) {
				stk.push(curChar);
				store.add(curChar);
			}else{
				if(!store.contains(curChar)) {
					while(!stk.isEmpty() && curChar < stk.peek()) {
							if(map.get(stk.peek()) > 0) {
								//pop
								store.remove(stk.peek());
								stk.pop();
							}else{
								break;
							}
					}
					stk.push(curChar);
					store.add(curChar);
				}
			}
		}
		char[] ary = new char[stk.size()];
		for(int i= ary.length-1;i>=0;i--){
			ary[i] = stk.pop();
		}
		
		return String.valueOf(ary);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicateLetters("acbabc"));
	}

}
