package com.martin.lc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class minHeightTree {
	
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList<Integer>();
		int shortestLen = Integer.MAX_VALUE;
		HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<n;i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		
		if(edges!=null) {
			for(int i=0;i<edges.length;i++) {
				graph.get(edges[i][0]).add(edges[i][1]);
				graph.get(edges[i][1]).add(edges[i][0]);
			}
		}
		
		for(int i=0;i<n;i++){
			if(graph.get(i).size()==0){
				if(shortestLen!=1){
					shortestLen =1;
					res = new ArrayList<Integer>();
				}
				
				res.add(i);
				continue;
			}
			HashSet<Integer> visited = new HashSet<Integer>();
			visited.add(i);
			int curLen = maxLen(i,graph,visited);
			if(curLen<shortestLen){
				shortestLen = curLen;
				res = new ArrayList<Integer>();
				res.add(i);
			}else if(curLen == shortestLen){
				res.add(i);
			}else{
				continue;
			}
		}
		
		return res;
	}
	
	public static int maxLen(int cur , HashMap<Integer,ArrayList<Integer>> graph, HashSet<Integer> visited) {
		ArrayList<Integer> nexts = graph.get(cur);
		int thisMax = 0;
		for(Integer next : nexts){
			if(!visited.contains(next)){
				visited.add(next);
				int max = maxLen(next,graph,visited);
				thisMax = Math.max(max, thisMax);
				visited.remove(next);
			}
		}
		
		return thisMax +1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		List<Integer> res = findMinHeightTrees(6,edges);
		System.out.println();
	}

}
