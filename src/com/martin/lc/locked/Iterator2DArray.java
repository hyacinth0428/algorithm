package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Show Hint 
 Google, Airbnb,Twitter
 * */
public class Iterator2DArray implements Iterator<Integer> {
	 private int x;
	    private int y;
	    private ArrayList<Integer> size;
	    private ArrayList<List<Integer>> content;
	    public Iterator2DArray(List<List<Integer>> vec2d) {
	        this.x = 0;
	        this.y = 0;
	        this.size = new ArrayList<Integer>();
	        this.content = new ArrayList<List<Integer>>();
	        for(List<Integer> list : vec2d){
	            content.add(list);
	            size.add(list.size() - 1);
	        }
	    }

	    @Override
	    public Integer next() {
	        if(hasNext()){
	            int res = content.get(x).get(y);
	            if( y==size.get(x) ){
	                y = 0;
	                x = x+1;
	            }else{
	                y++;
	            }
	            return res;
	        }else{
	            return null;
	        }
	    }

	    @Override
	    public boolean hasNext() {
	        while(x<size.size()){
	            if(size.get(x)== -1) x++;
	            else break;
	        }
	        
	        return x < size.size();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
