package com.martin.lc.locked;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
 * the distance to a gate is less than 2147483647. Fill each empty room with the
 * distance to its nearest gate. If it is impossible to reach a gate, it should
 * be filled with INF.
 * 
 * For example, given the 2D grid: INF -1 0 INF INF INF INF -1 INF -1 INF -1 0
 * -1 INF INF After running your function, the 2D grid should be: 3 -1 0 1 2 2 1
 * -1 1 -1 2 -1 0 -1 3 4 Hide Company Tags Google Facebook Show Tags Show
 * Similar Problems
 * 
 * */
public class GateAndWall {
	private int[] xRotate = { -1, 1, 0, 0 };
	private int[] yRotate = { 0, 0, -1, 1 };

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0)
			return;
		int height = rooms.length;
		int width = rooms[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (rooms[i][j] == 0) {
					boolean[][] visited = new boolean[height][width];
					visited[i][j] = true;
					for (int k = 0; k < 4; k++) {
						dfs(rooms, visited, 1, i + xRotate[k], j + yRotate[k],
								height, width);
					}
				}
			}
		}
	}

	public void dfs(int[][] rooms, boolean[][] visited, int dis, int x, int y,
			int height, int width) {
		if (x < 0 || y < 0 || x >= height || y >= width || visited[x][y]
				|| rooms[x][y] <= 0)
			return;
		else {
			// valid point
			rooms[x][y] = Math.min(dis, rooms[x][y]);
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				dfs(rooms, visited, dis + 1, x + xRotate[i], y + yRotate[i],
						height, width);
			}
			visited[x][y] = false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 },
				{ 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 },
				{ 0, -1, 2147483647, 2147483647 } };
		GateAndWall gw = new GateAndWall();
		gw.wallsAndGates(rooms);
		System.out.println();
	}

}
