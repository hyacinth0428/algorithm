package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

Google Facebook
 * 
 * */
public class MeetingRoomsII {
	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	public static class Node{
        public int time;
        public boolean isEnd;
        public Node(int time, boolean isEnd){
            this.time = time;
            this.isEnd = isEnd;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length==0) return 0;
        ArrayList<Node> nodes = new ArrayList<Node>();
        for(Interval it : intervals){
            nodes.add(new Node(it.start,false));
            nodes.add(new Node(it.end,true));
        }
        
        Comparator<Node> cmp = new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                if(n1.time == n2.time){
                    if(n1.isEnd == n2.isEnd) return 0;
                    else return n1.isEnd ? -1:1;
                }else{
                    return n1.time - n2.time;
                }
            }
        };
        
        Collections.sort(nodes,cmp);
        
        int cnt = 0;
        int max = 0;
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).isEnd) cnt--;
            else{
                cnt++;
                max = Math.max(max,cnt);
            }
        }
        
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
