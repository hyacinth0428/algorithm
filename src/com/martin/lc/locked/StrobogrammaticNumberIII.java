package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberIII {
	 List<String> size1;
	    List<String> size2;
	    int count =0;
	    public int strobogrammaticInRange(String low, String high) {
	        if(low==null || high==null) return 0;
	        if(low.charAt(0) ==  '-') low = "0";
	        if(high.charAt(0) == '-') return 0;
	        size1 = new ArrayList<String>();
	        size1.add("0");
	        size1.add("1");
	        size1.add("8");
	        size2 = new ArrayList<String>();
	        size2.add("00");
	        size2.add("11");
	        size2.add("69");
	        size2.add("88");
	        size2.add("96");
	        
	        int hLen = high.length();
	        int lLen = low.length();

	        for(int i=lLen;i<=hLen;i++){
	            getAll(low,high,0,i-1,new char[i]);
	        }
	        
	        return count;
	    }
	    
	    public void getAll(String low, String high, int start, int end, char[] buffer){
	        if(start > end){
	            String str = String.valueOf(buffer);
	            if(compare(low,str) && compare(str,high)) count++;
	        }else if(start == end){
	            for(String s : size1){
	                buffer[start] = s.charAt(0);
	               String str = String.valueOf(buffer);
	              if(compare(low,str) && compare(str,high)) count++;
	            }
	        }else{
	            for(String s : size2){
	                if(start == 0 && s.equals("00")) continue;
	                buffer[start] = s.charAt(0);
	                buffer[end] = s.charAt(1);
	                getAll(low,high,start+1,end-1,buffer);
	            }
	        }
	    }
	    
	    private boolean compare(String s1, String s2) {
	        if (s1.length() == s2.length()) {
	            if (s1.compareTo(s2) <= 0) {
	                return true;
	            } else {
	                return false;
	            }
	        }

	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int haha = "123".compareTo("1222");
		System.out.println();
	}

}
