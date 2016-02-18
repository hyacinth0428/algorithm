package com.martin.lc.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class recoverItineray {
	public static int getIntVal(String s){
		int res = 0;
		for(int i=0;i<3;i++) {
			int curInt = s.charAt(i) - 'A';
			res <<=4;
			res |= curInt;
		}
		return res;
	}
	
	public static List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<String>();
		if(tickets==null || tickets.length == 0) return res;
		//graph
		HashMap<String,PriorityQueue<String>> graph = new  HashMap<String, PriorityQueue<String>>();
		buildGraph(tickets,graph);
		if(!graph.containsKey("JFK")) return res;
		findPath(graph,res);
		return res;
    }
	
	public static void buildGraph(String[][] tickets,HashMap<String,PriorityQueue<String>> graph) {
		for(int i=0;i<tickets.length;i++){
			String from = tickets[i][0];
			String to = tickets[i][1];
			if(graph.containsKey(from)){
				graph.get(from).offer(to);
			}else{
				Comparator<String> cmp = new Comparator<String>(){
					@Override
					public int compare(String s1,String s2){
						return getIntVal(s1)-getIntVal(s2);
					}
				};
				graph.put(from, new PriorityQueue<String>(1,cmp));
				graph.get(from).offer(to);
			}
		}
	}
	
	public static void findPath(HashMap<String,PriorityQueue<String>> graph, List<String> res) {
		String curString = "JFK";
		res.add(curString);
		while(graph.containsKey(curString) && !graph.get(curString).isEmpty()) {
			curString = graph.get(curString).poll();
			res.add(curString);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data1 = {"A","C","B","AC"};
		Arrays.sort(data1);
		String[][] data = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		Arrays.sort(data);
		List<String> res = findItinerary(data);
		System.out.println(res);
	}

}
