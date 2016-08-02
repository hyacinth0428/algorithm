package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

 Facebook


 * */
public class MeetingRooms {
	 public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	public static class Node{
        public int time;
        public boolean isStart;
        public Node(int time, boolean s){
            this.time = time;
            this.isStart = s;
        }
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals==null || intervals.length <= 1) return true;
        int cnt = 0;
        ArrayList<Node> nodes = new ArrayList<Node>();
        for(Interval it : intervals){
            nodes.add(new Node(it.start,true));
            nodes.add(new Node(it.end,false));
        }
        
        Comparator<Node> cmp = new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                if(n1.time == n2.time){
                    if(n1.isStart==n2.isStart) return 0;
                    else return n1.isStart? 1 : -1;
                }else{
                    return n1.time -n2.time;
                }
            }
        };
        
        Collections.sort(nodes,cmp);
        
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).isStart){
                cnt++;
                if(cnt>1) return false;
            }else{
                cnt--;
            }
        }
        
        return true;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
