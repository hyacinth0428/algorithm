package com.martin.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class PaintHouseII {
    public static class Node {
	        public int[] cost;
	        public Node(int k) {
	            cost = new int[k];
	        }
	    }
	    
    public int minCostII(int[][] costs) {
	        // Write your code here
    	if(costs == null || costs.length == 0 ) return 0;
    	int k = costs[0].length;
    	int n = costs.length;
    	Node[] f = new Node[n];
    	
    	for(int i=0;i<n;i++) {
    		f[i] = new Node(k);
    		findOptimal(costs, f, i, k);
    	}
    	
    	int min = Integer.MAX_VALUE;
    	for(int i=0; i<k; i++) {
    		min = Math.min(f[n-1].cost[i], min);
    	}
    	
    	return min;
	}
    
    public void findOptimal(int[][] costs, Node[] f, int i, int k){
    	if( i == 0 ) {
    		for(int j =0;j<k;j++) {
    			f[0].cost[j] = costs[0][j];
    		}
    	}else{
    		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    		for(int j = 0;j < k;j++) {
    			pq.offer(f[i-1].cost[j]);
    		}
    		
    		for(int j=0;j<k;j++) {
    			pq.remove(f[i-1].cost[j]);
    			f[i].cost[j] = pq.peek();
    			pq.offer(f[i-1].cost[j]);
    		}
    	}
    }
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length==0 || matrix[0].length ==0) return res;
        int height = matrix.length;
        int width = matrix[0].length;
        
        int loop = Math.min(height/2,width/2);
        
        for(int l=0; l<=loop;l++){
            int left = 0 + l;
            int right = width -1 - l;
            int top = 0 + l;
            int down = height -1 - l;
            
            //single line
            if(left == right){
                for(int i = top; i <= down; i++) res.add(matrix[i][left]);
                continue;
            }
            
            if(top == down){
                for(int i= left; i <=right; i++) res.add(matrix[top][i]);
                continue;
            }
            
            for(int i= left;i < right;i++){
                res.add (matrix[top][i]);
            }
            
            for(int i=top;i<down;i++){
                res.add(matrix[i][right]);
            }
            
            for(int i=right;i>left;i--){
                res.add(matrix[down][i]);
            }
            
            for(int i=down; i>top;i--){
                res.add(matrix[i][left]);
            }
        }
        
        return res;
     }
    
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length<2) return true;
        int start =0;
        int end = 0;
        while(end < nums.length-1){
            int newEnd = end;
            for(int i=start;i<=end;i++){
                newEnd = Math.max(i + nums[i],end);
                if(newEnd >= nums.length-1) return true;
            }
            if( newEnd <= end) 
            	return false;
            start = end +1;
            end = newEnd;
        }
        
        return true;
    }
    
    public static String minWindow(String s, String t) {
        if(s == null || t==null) return "";
        if(s.length() == 0 || t.length() ==0) return "";
        int[] need = new int[256];
        int[] got = new int[256];
        for(int i=0;i<t.length();i++) need[t.charAt(i)]++;
        
        Deque<Integer> dq = new LinkedList<Integer>();
        int runner = 0;
        String res = s;
        boolean found = false;
        int needCnt = t.length();
        
        while( runner < s.length()){
            char curChar = s.charAt(runner);
            if(need[curChar] == 0) runner++;
            else{
                dq.offerLast(runner);
                got[curChar]++;
                //count
                if(got[curChar] <= need[curChar]){
                    needCnt--;
                    if(needCnt==0){
                        found = true;
                        res = (res.length() < dq.peekLast() - dq.peekFirst() + 1) ? res: s.substring(dq.peekFirst(),dq.peekLast() + 1);
                        
                        while(!dq.isEmpty()){
                            char popedChar = s.charAt(dq.pollFirst());
                            got[popedChar]--;
                            if(got[popedChar] < need[popedChar]){
                                needCnt--;
                                runner++;
                                break;
                            }else{
                                //still contains all
                                res = (res.length() < dq.peekLast() - dq.peekFirst() + 1) ? res: s.substring(dq.peekFirst(),dq.peekLast() + 1);
                            }
                        }
                    }else runner++;
                }else runner++;
            }
        }
        
        return found? res:"";
    }
    public  static String getPermutation(int n, int k) {
        if(n==0) return "";
        if(n==1) return "1";
        int allPermutationCnt = 1;
        HashMap<Integer,Integer> pcMap = new HashMap<Integer,Integer>();
        Iterator<Map.Entry<Integer,Integer>> it = pcMap.entrySet().iterator();
        for(int i=1;i<=n;i++) {
            allPermutationCnt *= i;
            pcMap.put(i,allPermutationCnt);
        }
        
        k = k%allPermutationCnt;
        
      
        int[] res = new int[n];
        for(int i=0;i<res.length;i++) res[i] = i+1;
        
        findRes(k,0,res,pcMap);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.length;i++) sb.append(res[i]);
        return sb.toString();
    }
    
    public static  void findRes(int k, int index, int[] res,HashMap<Integer,Integer> map){
        //from number index+1
        if(k==1) return;
        int cut = 1;
        while( cut <= res.length - index){
            if( k<= map.get(cut) ) break;
            else cut++;
        }
        
        if( k == map.get(cut)){
            swap(res, res.length-cut,res.length-1);
        }else{
            index = res.length - cut;
            int times = k/map.get(cut-1);
            int shouldBeIndex = index + times ;
            int shouldBeVal = res[index + times ];
            if( k%map.get(cut-1) !=0){
            	for(int i = shouldBeIndex -1;i >= index;i--){
            		res[i+1]= res[i];
            	}
            	res[index] = shouldBeVal;
            	k -= times * map.get(cut-1);
            	findRes(k,index+1,res,map);
            }else{
            	    shouldBeIndex = index + times -1 ;
                    shouldBeVal = res[index + times -1];
            		for(int i = shouldBeIndex -1;i >= index;i--){
            			res[i+1]= res[i];
            		}
            		res[index] = shouldBeVal;
            		swap(res,index+1,res.length-1);
        		}
        	}
        
        
    }
    
    public static void swap (int[] ary, int start, int end){
        while(start < end){
            int tmp = ary[start];
            ary[start] = ary[end];
            ary[end] = tmp;
            start++;
            end--;
        }
    }
    
    public static void wahahah(List<List<Integer>> iii){
    	List<Integer> first = iii.get(0);
    	List<Integer> second = iii.get(1);
    	first.set(0, 8);
    	second.set(0, 8);
    }
    
   
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0 ) return s;
        String[] ary = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=ary.length-1;i>=0;i--){
        	String ss = ary[i];
            if(!ary[i].equals(" ") ) sb.append(ary[i]).append(" ");
        }
        
        if(sb.length() == 0) return "";
        
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] saRY = "A  A A    ".split(" ");
		for(String s : saRY){
			System.out.println(s);
		}
		int val =-2;
		int index = 0;
        while(val != 0){
            if(index == 32){
            	System.out.print("wawaa");
            }
            index ++;
            val >>=1;
        }
		List<List<Integer>> test = new ArrayList<List<Integer>>();
		List<Integer> yi = new ArrayList<Integer>();
		yi.add(1);
		List<Integer> er = new ArrayList<Integer>();
		er.add(2);
		test.add(yi);
		test.add(er);
		wahahah(test);
		String mirES = minWindow("ADOBECODEBANC","ABC");
		int[] ary = {1};
		//int[] rr = plusOne(ary);
		boolean wahaa = canJump(ary);
		int[][] m = {
				{ 1, 2, 3, 0 },
				{ 4, 5, 6, 10 },
				{ 7, 8, 9, 11 }
				};
		
		List<Integer> res = spiralOrder(m);
		
		String s = "";
		//String sub = s.substring(1,s.length());
		System.out.println();
		int[] ary1 = new int[3];
		int[] ary2 = new int[3];
		Arrays.fill(ary1, 1);
		Arrays.fill(ary2, 2);
		ary2 = ary1;
		ary1 = new int[3];
		System.out.println();
	}

}
