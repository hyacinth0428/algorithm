package com.martin.lc;

public class Stock_Cooldown {
	
	public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0 || prices.length ==1) return 0;
        int len= prices.length;
        int[] f= new int[len];
        f[1] = prices[1] > prices[0] ? prices[1]-prices[0] : 0;
        
        //f[i]
        for(int i=2; i<len; i++){
        	f[i] = f[i-1]; 
        	int curVal=prices[i];
        	for(int j=i-1;j>=0;j--){
        		if(prices[j] < curVal){
        			int pre = j-2;
        			int preVal = 0;
        			if(pre > 0) {
        				preVal = f[pre];
        			}
        			
        			f[i] = Math.max(f[i], preVal+curVal - prices[j]);
        		}
        	}
        }
        
        return f[len-1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = {1,2,9,0,2};
		int res =  maxProfit(ary);
		System.out.println();
	}

}
