package com.martin.lc.locked;

import java.util.ArrayList;

/**
 * Given two strings S and T, determine if they are both one edit distance
 * apart. 1.dp, too long 2.summerize, and make it O(n)
 * 两个字符串一样长的时候，说明有一个替换操作，我们只要看对应位置是不是只有一个字符不一样就行了
 * 一个字符串比另一个长1，说明有个增加或删除操作，我们就找到第一个对应位置不一样的那个字符
 * ，如果较长字符串在那个字符之后的部分和较短字符串那个字符及之后的部分是一样的，则符合要求 如果两个字符串长度差距大于1，肯定不对
 * */
public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null)
			return false;
		int len1 = s.length();
		int len2 = t.length();

		if (Math.abs(len1 - len2) >= 2)
			return false;

		if (len1 == len2) {
			int diffCnt = 0;
			for (int i = 0; i < len1; i++) {
				if (s.charAt(i) != t.charAt(i))
					diffCnt++;
				if (diffCnt > 1)
					return false;
			}
			return diffCnt == 1;
		} else {
			// boolean getMissing = false;
			return len1 > len2 ? verify(s, t) : verify(t, s);
		}
	}

	public boolean verify(String s1, String s2) {
		boolean added = false;
		int runner1 = 0;
		int runner2 = 0;
		while (runner2 < s2.length()) {
			if (s1.charAt(runner1) != s2.charAt(runner2)) {
				if (added)
					return false;
				else {
					added = true;
					runner1++;
				}
			} else {
				runner2++;
				runner1++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// cornercase:
		long a = 1;
		for(int i=1;i<=214;i++) a*=i;
		
		ArrayList<Integer> www = new ArrayList<Integer>();
		www.add(2);
		www.add(3);
		String s = String.valueOf(www);
		s.substring(0,1);
		System.out.println(a);
	}

}
