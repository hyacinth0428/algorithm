package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class wordPattern {
	public static boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null || pattern.length() == 0 || str.length() == 0) return false;
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length ) return false;
        
        LinkedHashMap<Character, ArrayList<Integer>> map1 = new LinkedHashMap<Character, ArrayList<Integer>>();
        LinkedHashMap<String, ArrayList<Integer>> map2 = new LinkedHashMap<String, ArrayList<Integer>>();
        
        for(int i=0;i<pattern.length();i++){
            char curChar = pattern.charAt(i);
            if(map1.containsKey(curChar)) map1.get(curChar).add(i);
            else {
                map1.put(curChar, new ArrayList<Integer>());
                map1.get(curChar).add(i);
            }
            
            String curStr = strs[i];
            if(!map2.containsKey(curStr))
                map2.put(curStr,new ArrayList<Integer>());
            map2.get(curStr).add(i);
        }
        
        if(map1.size()!= map2.size()) return false;
        ArrayList<ArrayList<Integer>> v1 = new ArrayList<ArrayList<Integer>>(map1.values());
        ArrayList<ArrayList<Integer>> v2 = new ArrayList<ArrayList<Integer>>(map2.values());

        return map1.values().equals(map2.values());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordPattern("abba","cat bb bb cat");
	}

}
