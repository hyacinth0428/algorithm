package com.martin.lc.locked;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to determine if the starting player can guarantee a win.
 * 
 * For example, given s = "++++", return true. The starting player can guarantee
 * a win by flipping the middle "++" to become "+--+".
 * 
 * Follow up: Derive your algorithm's runtime complexity.
 * 
 * Hide Company Tags Google Show Tags Show Similar Problems
 * 
 * */
public class FlipGameII {
	public boolean canWin(String s) {
		if (s == null || s.length() <= 1)
			return false;
		return canWin(s.toCharArray());
	}

	public boolean canWin(char[] ary) {
		for (int i = 0; i < ary.length - 1; i++) {
			if (ary[i] == '+' && ary[i + 1] == '+') {
				ary[i] = ary[i + 1] = '-';
				boolean win = !canWin(ary);
				ary[i] = ary[i + 1] = '+';
				if (win)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
