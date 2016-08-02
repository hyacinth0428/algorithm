package com.martin.lc.locked;
/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.
 * 
 * */
public class WordDistanceIII {
	 public int shortestWordDistance(String[] words, String word1, String word2) {
	        if(words == null || words.length == 0 || word1 == null || word2 == null) return 0;
	        int min1 = words.length;
	        int min2 = words.length;
	        int min = words.length;
	        int prevIndex1 = -1;
	        int prevIndex2 = -1;
	        int index1 = -1;
	        int index2 = -1;
	        for(int i=0;i<words.length;i++){
	            String str = words[i];
	            if(str.equals(word1)){
	                //update diff both
	                if(index1 == -1) index1=i;
	                else{
	                    prevIndex1 = index1;
	                    index1 = i;
	                    min1 = Math.min(min1,index1 - prevIndex1);
	                }
	                if(index2!=-1) min = Math.min(min,Math.abs(index1 - index2));
	            }else{
	                if(str.equals(word2)){
	                    if(index2 == -1) index2=i;
	                    else{
	                        prevIndex2 = index2;
	                        index2 = i;
	                        min2 = Math.min(min2,index2 - prevIndex2);
	                    }
	                    if(index1!=-1) min = Math.min(min,Math.abs(index1 - index2));
	                }
	            }
	        }
	        
	        return Math.min(min, Math.min(min1,min2));
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
