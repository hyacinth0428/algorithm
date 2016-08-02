package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].
 * */
public class PalindromePermutationII {
	//test cases: aabb, a, "", abbc, aaabbcc
	//When only 1 char repeat odd times, the odd times can be break to even times + 1, even times wil
	//be used as regular computation
	 public List<String> generatePalindromes(String s) {
	        List<String> res = new ArrayList<String>();
	        if(s==null || s.length() == 0) return res;
	        if(s.length() == 1){
	            res.add(s);
	            return res;
	        }
	        
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        for(int i=0;i<s.length();i++){
	            char curChar = s.charAt(i);
	            if(map.containsKey(curChar)) map.put(curChar, map.get(curChar) +1 );
	            else map.put(curChar,1);
	        }
	        int oddCnt = 0;
	        Character single = null;
	        StringBuilder sb = new StringBuilder();
	        Iterator<Map.Entry<Character,Integer>> it = map.entrySet().iterator();
	        while(it.hasNext()){
	            Map.Entry<Character,Integer> pair = it.next();
	            if( pair.getValue() %2 == 0){
	                for(int i=0;i<pair.getValue()/2;i++) sb.append(pair.getKey());
	            }else{
	            	oddCnt++;
	                single = pair.getKey();
	                if(oddCnt >1) return res;
	            }
	        }
	        int len = sb.length();
	        boolean[] visited = new boolean[len];
	        getAllPermutation(res,sb.toString(), single, new ArrayList<Character>(),visited);
	        return res;
	    }
	    
	    public void getAllPermutation(List<String> res,String s, Character single,ArrayList<Character> buffer,boolean[] visited){
	        if(buffer.size() == s.length()){
	            res.add(getStr(buffer,single));
	        }else{
	            Character prev = ' ';
	            for(int i=0;i<s.length();i++){
	                if(i==0 || s.charAt(i)!= prev){
	                    if(!visited[i]){
	                        prev = s.charAt(i);
	                        visited[i] = true;
	                        buffer.add(s.charAt(i));
	                        getAllPermutation(res,s,single,buffer,visited);
	                        buffer.remove(buffer.size()-1);
	                        visited[i] = false;
	                    }
	                }
	            }
	        }
	    }
	    
	    public String getStr(ArrayList<Character> buffer, Character single){
	        StringBuilder sb1 = new StringBuilder();
	        for(int i=0;i<buffer.size();i++) sb1.append(buffer.get(i));
	        StringBuilder sb2 = new StringBuilder();
	        for(int i=buffer.size()-1;i >=0;i--) sb2.append(buffer.get(i));
	        if(single !=null) sb1.append(single);
	        return sb1.toString() + sb2.toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
