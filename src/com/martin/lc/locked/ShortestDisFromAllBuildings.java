package com.martin.lc.locked;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDisFromAllBuildings {
	private int[] xRotate = {-1,1,0,0};
    private int[] yRotate = {0,0,-1,1};
    
    public static class Node{
        public int beReached = 0;
        public int disSum = 0;
    }
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int height = grid.length;
        int width = grid[0].length;
        int buildingCnt = 0;
        Node[][] nodes = new Node[height][width];
         for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                nodes[i][j] = new Node();
            }
        }
        
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(grid[i][j] == 1){
                    buildingCnt++;
                    bfs(nodes,grid,i,j);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(nodes[i][j].beReached == buildingCnt){
                    found = true;
                    min = Math.min(min,nodes[i][j].disSum);
                }
            }
        }
        return min;
    }
    
    public void bfs(Node[][] nodes, int[][] grid, int x, int y){
        int height = grid.length;
        int width = grid[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        HashSet<Long> visited = new HashSet<Long>();
        queue.offer(x);
        queue.offer(y);
        boolean firstTime = true;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size/2;i++){
                int cX = queue.poll();
                int cY = queue.poll();
                Long index = (long)cX * (long)width + (long)cY;
                if(visited.contains(index)) continue;
                if(cX <0 || cX >= height || cY <0 || cY >=width ) continue;
                if(grid[cX][cY]!=0){
                	if(!firstTime) continue;
                	else firstTime = false;
                }
                visited.add(index);
                nodes[cX][cY].beReached ++;
                nodes[cX][cY].disSum += level;
                
                for(int j=0;j<4;j++){
                    queue.offer(cX+xRotate[j]);
                    queue.offer(cY+yRotate[j]);
                }
            }
            level++;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] b = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		ShortestDisFromAllBuildings w = new ShortestDisFromAllBuildings();
		w.shortestDistance(b);
		
	}

}
