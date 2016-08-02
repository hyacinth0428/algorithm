package com.martin.lc;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<=1) return nums;
        int len = nums.length;
        Deque<Integer> dq = new LinkedList<Integer>();
        int[] res = new int[len - k +1];
        int index = 0;
        //handle first k
        int runner = 0;
        while(runner < k){
            if(dq.isEmpty() || nums[runner] <= nums[dq.peekLast()]){
                dq.offerLast(runner);
                runner++;
            }else{
                while(!dq.isEmpty()){
                    if(nums[runner] > nums[dq.peekLast()]) dq.pollLast();
                    else break;
                }
                dq.offerLast(runner);
                runner++;
            }
        }
        
        res[index++] = nums[dq.peekFirst()];
        while(runner < len){
            //remove out of range ones
            while(!dq.isEmpty()){
                if(dq.peekFirst() <= runner - k) dq.pollFirst();
                else break;
            }
            //push
            while(!dq.isEmpty()){
                if(nums[runner] > nums[dq.peekLast()]) dq.pollLast();
                else break;
            }
            dq.offerLast(runner);
            //add
            res[index++] = nums[dq.peekFirst()];
            runner++;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
