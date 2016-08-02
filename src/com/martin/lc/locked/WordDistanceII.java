package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

linkedin
 * 
 * */
public class WordDistanceII {
HashMap<String,ArrayList<Integer>> graph;
    
    public WordDistanceII(String[] words) {
        this.graph = new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<words.length;i++){
            if(!graph.containsKey(words[i])){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                graph.put(words[i],tmp);
            }else{
                graph.get(words[i]).add(i);
            }
        }
        
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> l1 = graph.get(word1);
        ArrayList<Integer> l2 = graph.get(word2);
        int res = Integer.MAX_VALUE;
        int len1 = l1.size();
        int len2 = l2.size();
        int i = 0;
        int j = 0; 
        while(i<len1&&j<len2){
            res = Math.min(res, Math.abs( l1.get(i) - l2.get(j) ));
            if (l1.get(i) < l2.get(j)) i++;
            else j++;
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
