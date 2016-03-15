package com.martin.lc;

/**
 * Created by Martin on 3/14/16.
 */
public class HouseRobI {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums[0];
        int len = nums.length;
        int a = nums[0];
        int b = nums[1];
        b = Math.max(a,b);

        for(int i =0; i<nums.length ; i++) {
            int tmp = Math.max(nums[i]+a,b);
            a = b;
            b = tmp;
        }

        return b;
    }

    public static void main(String[] args) {

    }
}
