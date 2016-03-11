package com.martin.lc;

public class WallsAndGates {
	public static int[] xRotate = {1,-1,0,0};
	public static int[] yRotate = {0,0,-1,1};
	public static void wallsAndGates(int[][] rooms) {
		if(rooms == null || rooms.length ==0) return;
		int height = rooms.length;
		int width = rooms[0].length;
		boolean[][] visited = new boolean[height][width];
		for(int i = 0;i<height;i++) {
			for(int j=0;j<width;j++){
				if(rooms[i][j]==Integer.MAX_VALUE){
					rooms[i][j] = getMinDis(rooms,visited,i,j,0);
				}
			}
		}
	}
	
	public static int getMinDis(int[][] rooms, boolean[][] visited,int x, int y, int depth){
		if(x<0 || x>=rooms.length || y<0 || y >= rooms[0].length || visited[x][y] || rooms[x][y] == -1) return Integer.MAX_VALUE;
		if(rooms[x][y]==0) return depth;
		else{
			int res = Integer.MAX_VALUE;
			visited[x][y] = true;
			for(int i=0;i<4;i++) {
				res = Math.min(res, getMinDis(rooms,visited,x+xRotate[i],y+yRotate[i],depth+1));
			}
			visited[x][y] = false;
			return res;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] rooms = {
							{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
							{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
							{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
							{0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}
		};
		
		wallsAndGates(rooms);
		System.out.println(rooms);
		
	}

}
