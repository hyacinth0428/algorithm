package com.martin.lc.locked;

import java.util.Arrays;
/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

Hide Company Tags Google
Show Tags
Show Similar Problems

 * */

public class ThreeSumSmaller {
	public static int waha(int nums[], int target){
		       if(nums == null || nums.length < 3) return 0;
		       Arrays.sort(nums);
		       
		       int cnt = 0;
		       for(int i = 0;i <= nums.length - 3;i++){
		           int look = target - nums[i];
		           int start = i + 1;
		           int end = nums.length  - 1;
		           while(start < end){
		               int val = nums[start] + nums[end];
		               if( val < target){
		                   cnt += end - start;
		                   start++;
		               }else{
		                   end--;
		               }
		           }
		       }
		       return cnt;
		    
	}
	public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int cnt = 0;
        int len = nums.length;
        for(int i=0;i<=len-3;i++){
            int tt  = target - nums[i];
            int start = i+1;
            int end = len-1;
            
            while(start<end){
                int sVal = nums[start];
                int eVal = nums[end];
                int sum = eVal + sVal;
                if( sum < tt){
                    cnt += end - start;
                    start++;
                }else if( sum > tt){
                    end--;
                }else{
                    end--;
                }
            }
        }
        
        return cnt;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = {-2,0,1,3};
		waha(ary,2);
	}

}
