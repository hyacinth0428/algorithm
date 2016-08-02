package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.util.Queue;

public class TopKFrequentElement {
	public List<Integer> topKFrequent(int[] nums, int k) {
	       List<Integer> res = new ArrayList<Integer>();
	       if( nums == null || nums.length == 0) return res;
	       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	       for(int i=0;i<nums.length;i++){
	           if(!map.containsKey(nums[i])) map.put(nums[i],1);
	           else map.put(nums[i], map.get(nums[i]) + 1 );
	       }
	       
	       int min = Integer.MAX_VALUE;
	       int max = -1;
	       HashMap<Integer,Queue<Integer>> cntMap = new HashMap<Integer, Queue<Integer>>();
	       Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
	       //put in cntMap, update min, max
	       while(it.hasNext()){
	           Map.Entry<Integer,Integer> pair = it.next();
	           int rCnt = pair.getValue();
	           int element = pair.getKey();
	           if( !cntMap.containsKey(rCnt)) cntMap.put(rCnt, new LinkedList<Integer>());
	           cntMap.get(rCnt).offer(element);
	           min = Math.min(min, rCnt);
	           max = Math.max(max, rCnt);
	       }
	       
	       int level = max;
	       int rank = 1;
	       while(rank <= k){
	           if( cntMap.containsKey(level) && cntMap.get(level).size() > 0){
	               res.add(cntMap.get(level).poll());
	               rank++;
	           }else{
	               level--;
	           }
	       }
	       return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
