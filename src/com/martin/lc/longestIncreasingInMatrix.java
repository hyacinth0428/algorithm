package com.martin.lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class longestIncreasingInMatrix {
	public static class Node {
		public int x;
		public int y;
		public int value;
		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	public static int[] xRotate = { -1,1,0,0 };
	public static int[] yRotate = { 0,0,-1,1 };
	public static int[][] f;
	public static int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return 0;
		Comparator<Node> cmp = new Comparator<Node>() {
			@Override
			public int compare(Node n1,Node n2) {
				return n1.value - n2.value;
			}
		};
		
		List<Node> list = new ArrayList<Node>();
		int height = matrix.length;
		int width = matrix[0].length;
		f = new int[height][width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				list.add(new Node(i,j,matrix[i][j]));
				f[i][j] = 1;
			}
		}
		
		Collections.sort(list,cmp);
		int maxLen = 1;
		for(int i =0 ;i < list.size();i++) {
			Node curNode = list.get(i);
			int x = curNode.x;
			int y = curNode.y;
			for (int j=0;j<4;j++){
				int newX = x + xRotate[j];
				int newY = y + yRotate[j];
				if( newX >=0 && newX < height && newY >=0 && newY < width && matrix[x][y] < matrix[newX][newY]) {
					f[newX][newY] = Math.max(f[newX][newY], f[x][y]+1);
					maxLen = Math.max(maxLen, f[newX][newY]);
				}
			}
		}
		
		return maxLen;
	}
	
//	public static int findLongest(int[][] matrix, int x, int y, boolean[][] visited, int len) {
//		int curLen = len;
//		for(int i=0;i<4;i++) {
//			int newX = x + xRotate[i];
//			int newY = y + yRotate[i];
//			if(newX < 0 || newX >= matrix.length || newY < 0 || newY >=matrix[0].length || visited[newX][newY]) continue;
//			if(matrix[newX][newY] > matrix[x][y]) {
//				visited[newX][newY] = true;
//				if(localLen[newX][newY]!=0) curLen = Math.max(curLen, len + localLen[newX][newY]);
//				else curLen = Math.max(curLen, findLongest(matrix,newX,newY,visited,len+1));
//				visited[newX][newY] = false;
//			}
//		}
//		return curLen;
//	}
//	
//	public static int longestIncreasingPath(int[][] matrix) {
//		if( matrix == null || matrix.length == 0) return 0;
//		int height = matrix.length;
//		int width = matrix[0].length;
//		boolean[][] visited = new boolean[height][width];
//		localLen = new int[height][width];
//		int res = 0;
//		for(int i=0;i<height;i++) {
//			for(int j=0;j<width;j++) {
//				visited[i][j] = true;
//				localLen [i][j] = Math.max(localLen[i][j], findLongest(matrix,i,j,visited,1));
//				res = Math.max(res, localLen [i][j]);
//				visited[i][j] = false;
//			}
//		}
//		return res;
//	}
	
//	public static int longestIncreasingPath(int[][] matrix) {
//		if(matrix==null || matrix.length==0) return 0;
//		int height = matrix.length;
//		int width = matrix[0].length;
//		int maxLen = 1;
//		//down right
//		int[][] search = new int[height][width];
//		for(int i=0;i<height;i++){
//			for(int j=0;j<width;j++){
//				search[i][j] = 1;
//				if(isValid(i-1,j,height,width) && matrix[i][j] > matrix[i-1][j])
//					search[i][j] = Math.max(search[i][j], search[i-1][j]+1);
//				if(isValid(i,j-1,height,width) && matrix[i][j] > matrix[i][j-1])
//					search[i][j] = Math.max(search[i][j], search[i][j-1]+1);
//				maxLen = Math.max(maxLen, search[i][j]);
//			}
//		}
//		
//		//down left
//		search = new int[height][width];
//		for(int i=0;i<height;i++){
//			for(int j=width-1;j >=0;j--){
//				search[i][j] = 1;
//				if(isValid(i-1,j,height,width) && matrix[i][j] > matrix[i-1][j])
//					search[i][j] = Math.max(search[i][j], search[i-1][j]+1);
//				if(isValid(i,j+1,height,width) && matrix[i][j] > matrix[i][j+1])
//					search[i][j] = Math.max(search[i][j], search[i][j+1]+1);
//				maxLen = Math.max(maxLen, search[i][j]);
//			}
//		}
//		
//		//up right
//		search = new int[height][width];
//		for(int i=height-1;i>=0;i--){
//			for(int j=0;j < width;j++){
//				search[i][j] = 1;
//				if(isValid(i+1,j,height,width) && matrix[i][j] > matrix[i+1][j])
//					search[i][j] = Math.max(search[i][j], search[i+1][j]+1);
//				if(isValid(i,j-1,height,width) && matrix[i][j] > matrix[i][j-1])
//					search[i][j] = Math.max(search[i][j], search[i][j-1]+1);
//				maxLen = Math.max(maxLen, search[i][j]);
//			}
//		}
//		
//
//		//up left
//		search = new int[height][width];
//		for(int i=height-1;i>=0;i--){
//			for(int j=width-1;j >=0 ;j--){
//				search[i][j] = 1;
//				if(isValid(i+1,j,height,width) && matrix[i][j] > matrix[i+1][j])
//					search[i][j] = Math.max(search[i][j], search[i+1][j]+1);
//				if(isValid(i,j+1,height,width) && matrix[i][j] > matrix[i][j+1])
//					search[i][j] = Math.max(search[i][j], search[i][j+1]+1);
//				maxLen = Math.max(maxLen, search[i][j]);
//			}
//		}
//		return maxLen;
//	}
//
//	public static boolean isValid(int x, int y,int height,int width) {
//		return (x >=0) && (x<height) && (y>=0) && (y<width);
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {
				{9,9,4},
	             {6,6,8},
	             {2,1,1}
		             };
		
		int res = longestIncreasingPath(input);
		
		System.out.println();
	}

}
