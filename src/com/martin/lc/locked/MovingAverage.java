package com.martin.lc.locked;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
Hide Company Tags Google
Show Tags

 * */
public class MovingAverage {
	private int size ;
    private Queue<Double> queue = new LinkedList<Double>();
    //ERROR: You were : Double sum = 0; if you want to create a double.. you can't do this..
    private Double sum = new Double(0); 
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if(queue.size() < size){
            queue.offer((double)val);
            sum += (double)val;
            return sum /(double) queue.size();
        }else{
            sum -= queue.poll();
            sum += (double)val;
            queue.offer((double)val);
            return sum /size;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
