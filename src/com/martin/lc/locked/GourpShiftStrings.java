package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

Google, Uber
 * */
public class GourpShiftStrings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(int i=0;i<strings.length;i++){
            String pattern = getPattern(strings[i]);
            if(map.containsKey(pattern)) map.get(pattern).add(strings[i]);
            else{
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(strings[i]);
                map.put(pattern,tmp);
            }
        }
        
        for(ArrayList<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    
	/****/
    public String getPattern(String s){
        if(s.length() == 1) return "single";
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<s.length();i++){
                int val = s.charAt(i) - s.charAt(i-1);
                //精华，要补成正数，要不然就不对了
                val = val < 0? val +26:val;
                sb.append(val);
            }
            return sb.toString();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
