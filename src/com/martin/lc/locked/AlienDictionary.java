package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
	public static class Node{
        public Character val;
        public int dependentCnt;
        public HashSet<Character> dependsOnMe;
        public Node(Character val){
            this.val = val;
            this.dependsOnMe = new HashSet<Character>();
        }
    }
    
    public void buildGraph(HashMap<Character,Node> graph, String[] words){
       
        for(int i=1;i<words.length;i++){
            String prev = words[i-1];
            String cur = words[i];
           
            int j=0;
            while(j<Math.min(prev.length(),cur.length())){
                if( prev.charAt(j)!=cur.charAt(j)){
                    char prevC = prev.charAt(j);
                    char curC = cur.charAt(j);
                    //prev -> cur
                    //Do not give additional relationship
                    if(!graph.get(prevC).dependsOnMe.contains(curC)){
                        graph.get(prevC).dependsOnMe.add(curC);
                        graph.get(curC).dependentCnt++;
                    }
                    break;
                }
                j++;
            }
        }
    }
    
    public String alienOrder(String[] words) {
        if(words==null || words.length == 0) return "";
        HashMap<Character,Node> graph = new HashMap<Character,Node>();
        //put them all, since relationship may miss char
        for(int i=0;i<words.length;i++){
            String s = words[i];
            for(int j=0;j<s.length();j++){
                char curChar = s.charAt(j);
                if(!graph.containsKey(curChar)) graph.put(curChar, new Node(curChar));
            }
        }
        buildGraph(graph,words);
        int need = graph.size();
        Queue<Node> queue = new LinkedList<Node>();
        StringBuilder sb = new StringBuilder();
        for(Node n : graph.values()){
            if(n.dependentCnt ==0 ){
                need--;
                queue.offer(n);
                sb.append(n.val);
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node curNode = queue.poll();
                for(Character c : curNode.dependsOnMe){
                    Node nb = graph.get(c);
                    nb.dependentCnt--;
                    if(nb.dependentCnt == 0){
                        need--;
                        queue.offer(nb);
                        sb.append(nb.val);
                    }
                }
            }
        }
        
        return need == 0? sb.toString() : "";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> wa = new ArrayList<String>();
		wa.add("a");
		wa.add("b");
		wa.add("c");
		for(String s : wa){
			System.out.println(s);
		}
		
		String ss = "abcdb";
		
	}

}
