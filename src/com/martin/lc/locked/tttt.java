package com.martin.lc.locked;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import com.martin.lc.oddEvenList.ListNode;

public class tttt {
	public static class Node {
		public Character name;
		public int depCnt = 0;
		public ArrayList<Character> dependsOnMe = new ArrayList<Character>();

		public Node(Character name) {
			this.name = name;
		}
	}

	public void buildGraph(String[] words, HashMap<Character, Node> graph) {
		int up = 0;
		int low = 1;
		while (low < words.length) {
			int len = Math.min(words[up].length(), words[low].length());
			for (int i = 0; i < len; i++) {
				char cSmall = words[up].charAt(i);
				char cBig = words[low].charAt(i);
				// update graph and break
				if (cSmall != cBig) {
					if (!graph.containsKey(cSmall))
						graph.put(cSmall, new Node(cSmall));
					if (!graph.containsKey(cBig))
						graph.put(cBig, new Node(cBig));
					graph.get(cSmall).dependsOnMe.add(cBig);
					graph.get(cBig).depCnt++;
					break;
				}
			}

			up = low;
			low = low + 1;
		}
	}

	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern == null || pattern.length() == 0 || str == null
				|| str.length() == 0)
			return false;
		return dfs(pattern, str, 0, 0, new HashMap<Character, String>());
	}

	public boolean dfs(String pattern, String str, int pIndex, int sIndex,
			HashMap<Character, String> map) {
		if (sIndex == str.length()) {
			if (pIndex == pattern.length())
				return true;
			else
				return false;
		} else {
			char curP = pattern.charAt(pIndex);
			// if not there, try all possible and move on
			if (!map.containsKey(curP)) {
				for (int i = sIndex; i < str.length(); i++) {
					map.put(curP, str.substring(sIndex, i + 1));
					if (dfs(pattern, str, pIndex + 1, i + 1, map))
						return true;
					map.remove(curP);
				}
			} else {
				// if there check if sIndex + size is match, check out of
				// bound!!
				String pStr = map.get(curP);
				int size = pStr.length();
				if (sIndex + size > str.length())
					return false;
				else {
					String now = str.substring(sIndex, sIndex + size);
					if (now.equals(pStr)) {
						return dfs(pattern, str, pIndex + 1, sIndex + size, map);
					} else {
						return false;
					}
				}
			}
			return false;
		}
	}

	public static int listLen(ListNode head) {
		int cnt = 0;
		while (head != null) {
			head = head.next;
			cnt++;
		}
		return cnt;
	}

	public static int getV(String s) {
		int start = 0;
		int end = start + 1;
		while (end < s.length()) {
			if (s.charAt(end) >= '0' && s.charAt(end) <= '9')
				end++;
			else
				break;
		}
		return Integer.parseInt(s.substring(start, end));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		//for(Integer inn : set){
		//	set.add(4);
		//}
		//List<String> redoList = new ArrayList<String>(set);
		
		for(Integer inn : set){
			System.out.println(inn);
		}
	}

}
