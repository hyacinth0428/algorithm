package com.martin.lc.locked;

import java.util.HashMap;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

Facebook, palantir
 * */
public class MaxLenSubArraySumEqualK {
	int haha = 0;
	public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int res = 0;
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            cnt += nums[i];
            if(!map.containsKey(cnt)) map.put(cnt,i);
            int look = cnt - k;
            if( map.containsKey(look)){
                res = Math.max(res,i - map.get(look));
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ww = 2.3333;
		int w = (int)Math.round(ww);
		System.out.println(w);
	}

}
