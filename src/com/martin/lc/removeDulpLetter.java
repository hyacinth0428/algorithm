package com.martin.lc;

import java.util.Arrays;

public class removeDulpLetter {
	public static String removeDuplicateLetters(String s) {
        if(s==null || s.length()<2) return s;
        StringBuilder sb = new StringBuilder();
        int[] position = new int[26];
        Arrays.fill(position, -1);
        
        int len = s.length();
        for(int i=0;i<len;i++){
        	char curChar= s.charAt(i);
        	int index = curChar - 'a';
        	
        	if(sb.length()==0) {
        		sb.append(s.charAt(i));
        		position[index] = 0;
        		continue;
        	}
        	
        	if(position[index] == -1){
        		sb.append(curChar);
        		position[index] = sb.length()-1;
        	}else {
        		int curPosition = position[index];
        		if(curPosition == sb.length()-1) continue;
        		
        		for(int k = curPosition+1;k<sb.length(); k++){
        			if(sb.charAt(k) < curChar){
        				for(int j=curPosition+1 ;j <sb.length();j++){
                			position[sb.charAt(j) - 'a']--;
                		}
        				sb.append(curChar);
                		sb.delete(curPosition, curPosition+1);
                		position[index] = sb.length()-1;
        			}
        		}
        	}
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = removeDuplicateLetters("dcbacdcd");
		System.out.println();
	}

}
