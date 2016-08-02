package com.martin.lc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public static class Node{
        public int dependent;
        public ArrayList<Integer> dependsOnMe;
        public Node(){
            this.dependent = 0;
            this.dependsOnMe = new ArrayList<Integer>();
        }
    }
    
    public void buildGraph(HashMap<Integer,Node> graph, int[][] prerequisites){
        // depends on 1 to finish 0
        for(int i=0;i<prerequisites.length;i++){
            int me = prerequisites[i][0];
            int dependsOn = prerequisites[i][1];
            if(graph.containsKey(me)){
                graph.get(me).dependent++;
            }else{
               Node curNode = new Node();
               curNode.dependent = 1;
               graph.put(me,curNode);
            }
            
            if(graph.containsKey(dependsOn)){
                graph.get(dependsOn).dependsOnMe.add(me);
            }else{
                Node curNode = new Node();
                curNode.dependsOnMe.add(me);
                graph.put(dependsOn,curNode);
            }
        
        }
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <=0 || prerequisites == null || prerequisites.length == 0) return true;
        HashMap<Integer,Node> graph = new HashMap<Integer,Node>();
        buildGraph(graph,prerequisites);
        Queue<Node> queue = new LinkedList<Node>();
        for(Node node : graph.values()){
            if(node.dependent == 0) queue.offer(node);
        }
        
        int need = numCourses - queue.size();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node curNode = queue.poll();
                for(Integer d : curNode.dependsOnMe){
                    Node dn = graph.get(d);
                    dn.dependent--;
                    if(dn.dependent == 0) {
                        need--;
                        queue.offer(dn);
                    }
                }
            }
        }
        
        return need == 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
