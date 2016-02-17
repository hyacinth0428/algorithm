package com.martin.lc;

/**
 * Created by Martin on 2/16/16.
 */
public class IncreaseTriSubSequence {

    public boolean increasingTriplet(int[] nums) {
        if( nums==null || nums.length <3 ) return false;

        int firstOne = nums[0];
        int secOne = Integer.MAX_VALUE;

        for(int i=1;i<nums.length;i++) {
            //check if done
            if(nums[i] > secOne) return true;
            else {
                if(nums[i] <= firstOne) firstOne = nums[i];
                else {
                    //(firstOne,secOne]
                    secOne = nums[i];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
