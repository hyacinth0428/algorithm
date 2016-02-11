package com.martin.lc;

public class burstballoom {
	
	public static int maxCoins(int[] nums) {
		if(nums == null || nums.length ==0) return 0;
		int len = nums.length;
		int[] ary = new int[len+2];
		ary[0] = ary[len+1] = 1;
		for(int i=0;i<len;i++){
			ary[i+1] = nums[i];
		}
		len += 2;
		int[][] money = new int[len][len];
		
		for(int size=2;size<=len-1;size++) {
			for(int left=0;left+size<len;left++){
				int right = left +size;
				for(int i=left+1;i<right;i++){
					money[left][right] = Math.max(money[left][right], money[left][i]+ary[i]*ary[left]*ary[right]+money[i][right]);
				}
			}
		}
		
		return money[0][len-1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = {3,1,5,8};
		int res = maxCoins(ary);
		System.out.println();
	}

}
