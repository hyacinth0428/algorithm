package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PalindromePairs {
	public static class Node{
        public int index;
        public HashSet<String> set;
        public Node(int index){
            this.index = index;
            set = new HashSet<String>();
        }
    }
    
    public String reverse(String s){
        char[] ary = s.toCharArray();
        int start = 0;
        int end = ary.length - 1;
        while(start < end){
            char tmp = ary[start];
            ary[start] = ary[end];
            ary[end] = tmp;
            start ++;
            end --;
        }
        return String.valueOf(ary);
    }
    
    public boolean isPalin(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if( s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public void addPair(List<List<Integer>> res,  HashMap<String, Node> map, String s1, String s2){
         List<Integer> tmp = new ArrayList<Integer>();
         tmp.add(map.get(s1).index);
         tmp.add(map.get(s2).index);
         map.get(s1).set.add(s2);
         map.get(s2).set.add(s1);
         res.add(tmp);
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashMap<String, Node> map = new HashMap<String, Node>();
        for(int i=0;i<words.length;i++) map.put(words[i], new Node(i));
        for(int i=0;i<words.length;i++){
            String curStr = words[i];
            //find it self
            if(curStr.equals("")) continue;
            if(isPalin(curStr)){
                if(map.containsKey("")){
                    addPair(res,map,"",curStr);
                }
            }else{
                String reverse = reverse(curStr);
                if(map.containsKey(reverse) && !map.get(reverse).set.contains(curStr)){
                    addPair(res,map,reverse,curStr);
                }
                for(int j = 0;j<curStr.length()-1;j++){
                    String left = curStr.substring(0,j+1);
                    String right = curStr.substring(j+1);
                    if(isPalin(left)){
                        String rright = reverse(right);
                        if(map.containsKey(rright) && !map.get(rright).set.contains(curStr)){
                            addPair(res,map,curStr,rright);
                        }
                    }
                    if(isPalin(right)){
                        String rleft = reverse(left);
                        if(map.containsKey(rleft) && !map.get(rleft).set.contains(curStr)){
                           addPair(res,map,curStr,rleft);
                        }
                    }
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
