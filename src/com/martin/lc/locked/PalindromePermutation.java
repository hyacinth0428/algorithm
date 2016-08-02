package com.martin.lc.locked;

import java.util.HashMap;

/**
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 * Show Hint Hide Company Tags Google Uber Show Tags Show Similar Problems
 * 
 * 
 * */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() < 2)
			return true;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);
			if (map.containsKey(curChar))
				map.put(curChar, map.get(curChar) + 1);
			else
				map.put(curChar, 1);
		}

		int oddCnt = 0;
		for (Integer it : map.values()) {
			if ((it % 2) == 1) {
				oddCnt++;
				if (oddCnt > 1)
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
