package com.martin.lc;

/**
 * Created by Martin on 3/14/16.
 */
public class HouseRobII {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        //the first one must pick
        int a = nums[0];
        int b = nums[0];

        for(int i = 2;i < nums.length-1;i++) {
            int tmp = Math.max(nums[i] + a, b);
            a = b;
            b = tmp;
        }
        max = Math.max(max,b);

        //the first one must not pick
        a = 0;
        b = nums[1];

        for(int i=2; i< nums.length; i++) {
            int tmp = Math.max(nums[i]+a,b);
            a = b;
            b = tmp;
        }

        max = Math.max(max,b);
        return max;
    }
}
