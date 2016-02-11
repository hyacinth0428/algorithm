package com.martin.lc;

public class PowerOfThree {
	public static boolean isPowerOfThree(int n) {
        if(n<1) return false;
        double eps = 1E-10;
        double wah = Math.log((double)n)/Math.log((double)3);
        int In = (int) Math.round(wah);
        return Math.abs(wah - (double)In) < eps;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double wahaa = 1.999999999;
		int wahi= (int) Math.round(wahaa);
		boolean res = isPowerOfThree(243);
		System.out.println();
	}

}
