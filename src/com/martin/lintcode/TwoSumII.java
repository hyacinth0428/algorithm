package com.martin.lintcode;



import java.util.Arrays;

/**
 * Created by Martin on 3/21/16.
 */
public class TwoSumII {

    public static int twoSum2(int[] nums, int target) {
        // Write your code here
        if(nums==null || nums.length < 2 || target == Integer.MAX_VALUE || target == Integer.MIN_VALUE) return 0;

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int cnt = 0;

        while( start < end ) {
            if(nums[start] + nums[end] <= target) start ++;
            else {
                cnt += end - start;
                end --;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        int[] ary = {1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
        int res = twoSum2(ary,-64);
        System.out.println();
    }
}
