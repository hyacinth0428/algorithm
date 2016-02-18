package com.martin.lc;

public class BulbSwitch {
	public static int bulbSwitch(int n) {
	       if(n<1) return 0;
	       int cnt = 0;
	       for(int i=1; i*i <= n;i++) {
	    	   cnt++;
	       }
	       
	       return cnt;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bulbSwitch(3));
	}

}
