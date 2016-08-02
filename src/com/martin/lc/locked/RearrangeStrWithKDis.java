package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
Example 2:
str = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.
Example 3:
str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.

Google
 * */
public class RearrangeStrWithKDis {
	 public static class Node{
			public char val;
			public int cnt;
			public Node(char val){
				this.val = val;
				this.cnt = 1;
			}
		}
		 public  String rearrangeString(String str, int k) {
		         if(str == null  || str.length() < 2 || k <= 1) return str;
	            if(k>= str.length()) return "";
		        HashMap<Character,Node> map = new HashMap<Character,Node>();
		       
		        for(int i=0;i<str.length();i++){
		        	char curChar = str.charAt(i);
		        	if(!map.containsKey(curChar)) map.put(curChar, new Node(curChar));
		        	else map.get(curChar).cnt++;
		        }
		        
		        List<Node> nodes = new ArrayList<Node>(map.values());
		        Comparator<Node> cmp = new Comparator<Node>(){
		        	@Override
		        	public int compare(Node n1,Node n2){
		        		return n2.cnt - n1.cnt;
		        	}
		        };
		        
		        Collections.sort(nodes,cmp);
		        for(int i=0;i<nodes.size();i++){
		        	if(nodes.get(i).cnt == 1) nodes.get(i).cnt = -1;
		        }
		        int len = str.length();
		        int maxCnt = nodes.get(0).cnt;
		        if(len < maxCnt + (k-1)*(maxCnt -1)) return "";
		       
		        //construct size k strings
		        char[] ary = new char[len];
		        int index = 0;
		        while(index <= len - k){
		        	int curLen = 0;
		        	for(int i=0;i<nodes.size();i++){
		        		if(nodes.get(i).cnt > 0){
		        			ary[index++] = nodes.get(i).val;
		        			nodes.get(i).cnt--;
		        			curLen++;
		        		}
		        		//if(curLen == k) break;
		        	}
		        	
		        	if(curLen<k){
		        		for(int i=0;i<nodes.size();i++){
		        			if(nodes.get(i).cnt == -1){
		        				ary[index++] = nodes.get(i).val;
		        				nodes.get(i).cnt = 0;
		        				curLen++;
		        			}
		        			if(curLen == k) break;
		        		}
		        	}
		        	if(curLen < k) return "";
		        }
		        
		        while(index < len){
		        	for(int i=0;i<nodes.size();i++){
		        		if(nodes.get(i).cnt!=0){
		        			ary[index++] = nodes.get(i).val;
		        		}
		        		if(index == len) break;
		        	}
		        }
		        return String.valueOf(ary);
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
