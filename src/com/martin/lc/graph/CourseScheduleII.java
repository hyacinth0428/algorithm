package com.martin.lc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
	public static class Node{
	       public int val;
	       public int dependent;
	       public ArrayList<Integer> dependsOnMe;
	       public Node(int val){
	           this.val = val;
	           this.dependent = 0;
	           this.dependsOnMe = new ArrayList<Integer>();
	       }
	    }
	    
	    public void buildGraph(HashMap<Integer,Node> graph, int[][] prerequisites){
	        for(int i=0;i<prerequisites.length;i++){
	            int me = prerequisites[i][0];
	            int dependsOn = prerequisites[i][1];
	            graph.get(me).dependent++;
	            graph.get(dependsOn).dependsOnMe.add(me);
	        }
	    }
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	        int[] res = new int[numCourses];
	        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return res;
	        HashMap<Integer,Node> graph = new HashMap<Integer,Node>();
	        for(int i=0;i<numCourses;i++){
	            graph.put(i,new Node(i));
	        }
	        
	        Queue<Node> queue = new LinkedList<Node>();
	        int index = 0;
	        for(Node node: graph.values()){
	            if(node.dependent==0){
	                res[index++] = node.val;
	                queue.offer(node);
	            }
	        }
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i=0;i<size;i++){
	                Node curNode = queue.poll();
	                for(Integer n : curNode.dependsOnMe){
	                    Node nb = graph.get(n);
	                    nb.dependent--;
	                    if(nb.dependent == 0){
	                        res[index++] = nb.val;
	                        queue.offer(nb);
	                    }
	                }
	            }
	        }
	        
	        return index == numCourses ? res : new int[numCourses];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
