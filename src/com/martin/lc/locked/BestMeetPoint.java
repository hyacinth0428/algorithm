package com.martin.lc.locked;

/**
 * A group of two or more people wants to meet and minimize the total travel
 * distance. You are given a 2D grid of values 0 or 1, where each 1 marks the
 * home of someone in the group. The distance is calculated using Manhattan
 * Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * 
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * 
 * 1 - 0 - 0 - 0 - 1 | | | | | 0 - 0 - 0 - 0 - 0 | | | | | 0 - 0 - 1 - 0 - 0 The
 * point (0,2) is an ideal meeting point, as the total travel distance of
 * 2+2+2=6 is minimal. So return 6.
 * 
 * Twitter
 * 
 * */
public class BestMeetPoint {

	public int minTotalDistance(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int height = grid.length;
		int width = grid[0].length;
		int[] row = new int[height];
		int[] col = new int[width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (grid[i][j] == 1) {
					row[i]++;
					col[j]++;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int curVal = 0;
				for (int m = 0; m < height; m++) {
					if (m != i) {
						curVal += row[m] * Math.abs(m - i);
					}
				}

				for (int n = 0; n < width; n++) {
					if (n != j) {
						curVal += col[n] * Math.abs(n - j);
					}
				}
				min = Math.min(min, curVal);
			}
		}

		return min;
	}
	public static void change(String str){
		str = str.substring(1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "12334";
		change(ss);
		System.out.println();
	}

}
