package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Google
 * 
 * */
public class LineReflection {
	//Very Important!
	 public final static double EPS = 0.000001;
	    public boolean isReflected(int[][] points) {
	      if(points == null || points.length < 2) return true;
		      HashMap<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>();
		      //x,y
		      for(int i=0;i<points.length;i++){
		    	  int x = points[i][0];
		    	  int y = points[i][1];
		    	  if(!map.containsKey(y)) map.put(y, new HashSet<Integer>());
		    	  map.get(y).add(x);
		      }
		      Double golden = null;
		      //for every set
		      //sort
		      //cal mid (double)
		      //check mid itself
		      //check if mid == golden
		      for(HashSet<Integer> set : map.values()){
		    	  List<Integer> tmp = new ArrayList<Integer>(set);
		    	  Collections.sort(tmp);
		    	 // System.out.println();
		    	  Double mid = (double)tmp.get(0) + ( (double)tmp.get(tmp.size()-1) - (double)tmp.get(0))/2;
		    	  //check if this is valid
		    	  int i=0;
		    	  int j=tmp.size()-1;
		    	  while(i<=j){
		    		  double left = mid - (double)tmp.get(i);
		    		  double right = (double)tmp.get(j) - mid;
		    		  if(left!=right) {
		    		      //for(Integer in : tmp){
		    		      //    System.out.print(in+" ");
		    		      //}
		    		      return false;
		    		  }
		    		  i++;
		    		  j--;
		    	  }
		    	  if(golden==null) golden = mid;
		    	  else{
		    		  if(Math.abs(mid-golden) > EPS) {
		    		      //for(Integer in : tmp){
		    		      //    System.out.print(in+" ");
		    		      //}
		    		      //System.out.println("mid : " + mid + " golden : "+golden);
		    		      return false;
		    		  }
		    	  }
		      }
		      return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2;
		int b = -a;
		System.out.println(b);
	}

}
