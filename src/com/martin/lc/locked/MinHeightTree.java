package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinHeightTree {
	public void buildGraph(HashMap<Integer,ArrayList<Integer>> graph, int[][] edges){
        for(int i=0;i<edges.length;i++){
            int first = edges[i][0];
            int sec = edges[i][1];
            graph.get(first).add(sec);
            graph.get(sec).add(first);
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if(n<=0 || edges.length ==0) return res;
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<n;i++) graph.put(i,new ArrayList<Integer>());
        buildGraph(graph,edges);
        int minLen = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int minDepth = findDepth(graph,i);
            if(minDepth < minLen){
                minLen = minDepth;
                res.clear();
                res.add(n);
            }else{
                if(minDepth == minLen) res.add(n);
            }
        }
        return res;
    }
    
    public int findDepth(HashMap<Integer,ArrayList<Integer>> graph, int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        int h = 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        while( !queue.isEmpty()){
            h++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Integer cur = queue.poll();
                visited.add(cur);
                for(Integer nb : graph.get(cur)){
                    if(!visited.contains(nb)){
                        queue.offer(nb);
                    }
                }
            }
        }
        return h;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
