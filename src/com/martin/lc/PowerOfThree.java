package com.martin.lc;

public class PowerOfThree {
	public static boolean isPowerOfThree(int n) {
        if(n<1) return false;
        return Math.pow(3, Math.log((double)n)/Math.log((double)3)) == n;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = isPowerOfThree(8);
		System.out.println();
	}

}
