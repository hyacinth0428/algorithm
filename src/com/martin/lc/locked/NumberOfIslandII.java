package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?

Google
 * 
 * */
public class NumberOfIslandII {
	 public HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    public int headCnt = 0;
	    public int[] xRotate = {-1,1,0,0};
	    public int[] yRotate = {0,0,-1,1};
	    
	    public int findHead(int val){
	        while(val!=map.get(val)){
	            val = map.get(val);
	        }
	        return val;
	    }
	    
	    public List<Integer> numIslands2(int m, int n, int[][] positions) {
	        List<Integer> res = new ArrayList<Integer>();
	        if(positions == null || positions.length == 0 || m<=0 || n<=0) return res;
	        for(int i=0;i<positions.length;i++){
	            int x = positions[i][0];
	            int y = positions[i][1];
	            int val = x*n + y;
	            //if the position is not valid or it is already an island
	            if(x<0 || x>= m || y<0 || y>=n || map.containsKey(val)) res.add(headCnt);
	            else{
	                int head = -1;
	                for(int j=0;j<4;j++){
	                    int newX = x + xRotate[j];
	                    int newY = y + yRotate[j];
	                    //Wrong: you were doing newX*m
	                    int newVal = newX*n + newY;
	                    //if out of board, or it is 0
	                    if(newX <0 || newX >= m || newY <0 || newY >=n || !map.containsKey(newVal)) continue;
	                    
	                    int nHead = findHead(newVal);
	                    if(head==-1) head= nHead;
	                    else{
	                        //merge head if the head is not head;
	                        if(nHead!=head){
	                            headCnt--;
	                            map.put(nHead,head);
	                        }
	                    }
	                }
	                
	                if(head == -1){
	                   map.put(val,val);
	                   headCnt++;
	                } 
	                else map.put(val,head);
	                
	                res.add(headCnt);
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = "1200".indexOf("200",1);
		System.out.println();
	}

}
