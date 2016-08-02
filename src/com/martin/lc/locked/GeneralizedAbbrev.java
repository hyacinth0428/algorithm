package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example: Given word = "word", return the following list (order does not
 * matter): ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2",
 * "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"] Hide Company Tags
 * Google Show Tags Show Similar Problems
 * 
 * */
public class GeneralizedAbbrev {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<String>();
		if (word == null)
			return res;
		if (word.length() == 0) {
			res.add("");
			return res;
		}

		HashSet<String> pSet = new HashSet<String>();
		pSet.add("1");
		pSet.add(word.substring(0, 1));
		for (int i = 1; i < word.length(); i++) {
			HashSet<String> cSet = new HashSet<String>();
			for (String s : pSet) {
				int len = s.length();
				if (s.charAt(len - 1) >= '0' && s.charAt(len - 1) <= '9') {
					int runner = len - 1;
					while (runner >= 0) {
						if (s.charAt(runner) >= '0' && s.charAt(runner) <= '9')
							runner--;
						else
							break;
					}
					Long val = Long.parseLong(s.substring(runner + 1));
					// as num
					val += 1L;
					cSet.add(s.substring(0, runner + 1) + String.valueOf(val));
					// as it self
					cSet.add(s + word.substring(i, i + 1));
				} else {
					cSet.add(s + "1");
					cSet.add(s + word.substring(i, i + 1));
				}
			}
			pSet = new HashSet<String>(cSet);
		}
		for (String s : pSet)
			res.add(s);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
