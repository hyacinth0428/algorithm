package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StockIV {
	 public static int maxProfit(int k, int[] prices) {
	        if(prices == null || prices.length < 2 || k<=0 || k >= prices.length) return 0;
	        int len = prices.length;
	        int[][] f = new int[k][len];
	        int[][] oneTran = new int[len][len];
	        //f[0][i][j]
	        for(int i=0;i<len;i++){
	            int min = prices[i];
	            int maxPro = 0;
	            for(int j=i;j<len;j++){
	                min = Math.min(prices[j],min);
	                maxPro = Math.max(maxPro, prices[j] - min);
	                oneTran[i][j] = maxPro;
	            }
	        }
	        
	        for (int i = 0; i < oneTran.length; i++) {
	            for (int j = 0; j < oneTran[0].length; j++) {
	                System.out.print(oneTran[i][j] + " ");
	            }
	            System.out.print("\n");
	        }
	        f[0] = oneTran[0];
	        //f[l][i]  stringlen = l+1
	        for(int l= 1;l<k;l++){
	           for(int i = l+1;i<len;i++){
	               for(int j = l;j<= i-1;j++){
	                   f[l][i] = Math.max(f[l-1][j]+oneTran[j][i], f[l][i]);
	               }
	           }
	        }
	        System.out.print("\n");
	        System.out.print("\n");
	        System.out.print("\n");
	        
	        for (int i = 0; i < f.length; i++) {
	            for (int j = 0; j < f[0].length; j++) {
	                System.out.print(f[i][j] + " ");
	            }
	            System.out.print("\n");
	        }
	        return f[k-1][len-1];
	    }
	public static void changeMap(HashMap<Integer,Integer> map){
		for(Map.Entry<Integer, Integer> pair : map.entrySet()){
			if(pair.getValue() == 2) pair.setValue(3);
		}
	}
	public static int countPrimes(int n) {
        if(n<2) return 0;
        if(n==2) return 1;
        if(n==3) return 2;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        
        for(int i=4;i<=n;i++){
            boolean isPrime = true;
            for(Integer pr : primes){
                if( (i %pr) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) 
                primes.add(i);
        }
        for(Integer i : primes) System.out.print(i + " ");
        return primes.size();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//countPrimes(100);
		int[] ary = {1,5,3,7777,8777,2,9};
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    ArrayList<Integer> l1 = new ArrayList<Integer>();
	    ArrayList<Integer> l2 = new ArrayList<Integer>();
	    l1.add(1);
	    l2.add(2);
	    boolean eee = l1.equals(l2);
		map.put(1, 2);
		map.put(2, 4);
		changeMap(map);
		int aa = new HashSet<Integer>(map.values()).size();
		for(Map.Entry<Integer, Integer> pair : map.entrySet()){
			if(pair.getValue() == 2) pair.setValue(3);
		}
		List<Integer> set = new ArrayList<Integer>(map.values());
		maxProfit(3,ary);
	}

}
