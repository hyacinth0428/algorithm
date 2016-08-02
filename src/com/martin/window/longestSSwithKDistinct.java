package com.martin.window;

import java.util.HashMap;

public class longestSSwithKDistinct {
	 public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        // write your code here
	        //trigger: larger than k, and end
	      if(s == null || k < 1) return 0;
	      if(s.length() <=k) return s.length();
	      if(k == 1) return 1;
	      HashMap<Character,Integer> store = new HashMap<Character,Integer>();
	      int maxLen = 0;
	      store.put(s.charAt(0),0);
	      int start = 0;
	      int runner = 1;
	      int cnt = 1;
	      while(runner<s.length()) {
	          char curChar = s.charAt(runner);
	          if( store.containsKey(curChar)) {
	              store.put(curChar,runner);
	              runner++;
	          }else{
	              if(cnt == k) {
	                  maxLen = Math.max(maxLen,runner-start);
	                  int earliest = Integer.MAX_VALUE;
	                  for(Integer index : store.values()){
	                	  earliest = Math.min(earliest,index);
	                  }
	                  start = earliest +1;
	                  cnt--;
	              }else{
	                  store.put(curChar,runner);
	                  cnt++;
	                  runner++;
	              }
	          }
	      }
	      
	      maxLen = Math.max(maxLen,runner-start);
	      
	      return maxLen;
	      
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
