package com.martin.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 3/12/16.
 */
public class PalindromPair {

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0) {
            return res;
        }

        for(int i=0; i<words.length; i++)  {
            for(int j = i+1; j<words.length; j++) {
                if(isPalindrome(words[i],words[j])) {
                    List<Integer> tmp1 = new ArrayList<Integer>();
                    tmp1.add(i);
                    tmp1.add(j);
                    res.add(tmp1);
                }

                if(isPalindrome(words[j],words[i])) {
                    List<Integer> tmp2 = new ArrayList<Integer>();
                    tmp2.add(j);
                    tmp2.add(i);
                    res.add(tmp2);
                }
            }
        }

        return res;
    }

    public static boolean isPalindrome(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1 == "" || s2 == "") return false;

        String s3 = s1 + s2;
        int i = 0;
        int j = s3.length()-1;
        while ( i<j ) {
            if (s3.charAt(i) != s3.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> res = palindromePairs(words);
        System.out.println();
    }
}
