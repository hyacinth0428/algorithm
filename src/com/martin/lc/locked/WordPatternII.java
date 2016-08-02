package com.martin.lc.locked;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty substring in str.
 * 
 * Examples: pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true. pattern = "aabb",
 * str = "xyzabcxzyabc" should return false. Notes: You may assume both pattern
 * and str contains only lowercase letters.
 * 
 * Hide Company Tags Dropbox Uber 
 * Show Tags 
 * Show Similar Problems
 * */
public class WordPatternII {
	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern == null || str == null)
			return false;
		return find(pattern, str, 0, 0, new HashMap<Character, String>(),
				new HashSet<String>());
	}

	public boolean find(String pattern, String str, int pIndex, int sIndex,
			HashMap<Character, String> map, HashSet<String> store) {
		if (pIndex == pattern.length() || sIndex == str.length()) {
			if (pIndex == pattern.length() && sIndex == str.length())
				return true;
			else
				return false;
		} else {
			char pChar = pattern.charAt(pIndex);
			// If at the same pattern, then match before if exist
			if (map.containsKey(pChar)) {
				int len = map.get(pChar).length();
				if (sIndex + len <= str.length()) {
					String sub = str.substring(sIndex, sIndex + len);
					if (sub.equals(map.get(pChar))) {
						if (find(pattern, str, pIndex + 1, sIndex + len, map,
								store))
							return true;
					}
				}
			} else {
				// if not exist, make sure the word you want to add is not a
				// value for other pattern
				for (int i = sIndex; i < str.length(); i++) {
					String word = str.substring(sIndex, i + 1);
					if (!store.contains(word)) {
						map.put(pChar, str.substring(sIndex, i + 1));
						store.add(word);
						if (find(pattern, str, pIndex + 1, i + 1, map, store))
							return true;
						map.remove(pChar);
						store.remove(word);
					}
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
