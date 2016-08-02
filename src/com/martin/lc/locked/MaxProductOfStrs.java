package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"] Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4 The
 * two words can be "ab", "cd".
 * 
 * Example 3: Given ["a", "aa", "aaa", "aaaa"] Return 0 No such pair of words.
 * 
 * Credits: Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 * 
 * Hide Company Tags Google Show Tags
 * 
 * 
 * */
public class MaxProductOfStrs {
	public int maxProduct(String[] words) {
		if (words == null || words.length < 2)
			return 0;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i] != null && words[i].length() != 0) {
				int wLen = words[i].length();
				max = Math.max(max, wLen);
				min = Math.min(min, wLen);
				if (!map.containsKey(wLen))
					map.put(wLen, new ArrayList<Integer>());
				map.get(wLen).add(strV(words[i]));
			}
		}
		int res = 0;
		// len i
		for (int i = max; i >= min; i--) {
			// ERROR: You missed this
			if (!map.containsKey(i))
				continue;
			// jth
			for (int j = 0; j < map.get(i).size(); j++) {
				// get first
				int first = map.get(i).get(j);
				// to get sec
				for (int m = i; m >= min; m--) {
					boolean found = false;
					if (!map.containsKey(m))
						continue;
					for (int n = m == i ? j + 1 : 0; n < map.get(m).size(); n++) {
						int sec = map.get(m).get(n);
						if ((first & sec) == 0) {
							// ERROR: You returned..
							res = Math.max(res, i * m);
							found = true;
							break;
						}
					}
					if (found)
						break;
				}
			}
		}
		return res;
	}

	public int strV(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int res = 0;
		int len = s.length();
		for (int i = len - 1; i >= 0; i--) {
			char curChar = s.charAt(i);
			int v = curChar - 'a';
			int base = 1;
			base <<= v;
			res |= base;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> waha = new ArrayList<String>();
		String[] aa = {"wor1","2rd","1o1d","1ord","w2d","1or1","w1r1","2r1","3d","4","1o2","w1rd","wo2","wo1d","w3","word"};
		for(String s : aa){
			waha.add(s);
		}

		Collections.sort(waha);
		System.out.println();
	}

}
