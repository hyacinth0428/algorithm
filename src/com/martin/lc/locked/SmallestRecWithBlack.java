package com.martin.lc.locked;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestRecWithBlack {
	 private int[] xRotate = {-1,1,0,0};
	    private int[] yRotate = {0,0,-1,1};
	    
	    public static class Node{
	        public int x;
	        public int y;
	        public Node(int x, int y){
	            this.x= x;
	            this.y= y;
	        }
	    }
	    
	    public int minArea(char[][] image, int x, int y) {
	        if(image == null || image.length == 0) return 0;
	        int height = image.length;
	        int width = image[0].length;
	        int left = y;
	        int right = y;
	        int up = x;
	        int down = x;
	        boolean[][] visited = new boolean[height][width];
	        Queue<Node> queue = new LinkedList<Node>();
	        queue.offer(new Node(x,y));
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i=0;i<size;i++){
	                Node curNode = queue.poll();
	                if(curNode.x <0 || curNode.x >= height || curNode.y<0 || curNode.y >=width || visited[curNode.x][curNode.y]||image[curNode.x][curNode.y] == '0') continue;
	                
	                visited[curNode.x][curNode.y] = true;
	                left = Math.min(left,curNode.y);
	                right = Math.max(right,curNode.y);
	                up = Math.min(up,curNode.x);
	                down = Math.max(down,curNode.x);
	                for(int j = 0;j<4;j++){
	                    queue.offer(new Node(curNode.x+xRotate[j], curNode.y + yRotate[j]));
	                }
	            }
	        }
	        
	        return (right-left+1) * (down-up+1);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] image ={
		                 "0010".toCharArray(),
		                 "0110".toCharArray(),
		                 "0100".toCharArray()
		};
		
		SmallestRecWithBlack w = new SmallestRecWithBlack();
		w.minArea(image, 0, 2);
		
	}
	
}
