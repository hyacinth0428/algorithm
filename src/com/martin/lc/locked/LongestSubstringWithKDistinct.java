package com.martin.lc.locked;

import java.util.HashMap;
/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

Hide Company Tags Google
Show Tags
Show Similar Problems

 * */
public class LongestSubstringWithKDistinct {
	 public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        if(s==null) return 0;
	        if(s.length() <= k) return s.length();
	        if(k==0) return 0;
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        int maxLen = 0;
	        int start = 0;
	        int end = 0;
	        while(end < s.length()){
	            char curChar = s.charAt(end);
	            //new thing in
	            if(!map.containsKey(curChar)){
	                //calculate, and update
	                if(map.size() == k){
	                    maxLen = Math.max(maxLen, end - start);
	                    int early = end;
	                    for(Integer in : map.values()){
	                        early = Math.min(early, in);
	                    }
	                    map.remove(s.charAt(early));
	                    start = early + 1;
	                    map.put(curChar,end);
	                    end++;
	                }else{
	                    map.put(curChar,end);
	                    end++;
	                }
	            }else{
	                map.put(curChar, end);
	                end++;
	            }
	        }
	        
	        //final cal
	        maxLen = Math.max(maxLen, end  - start);
	        return maxLen;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
