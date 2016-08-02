package com.martin.lc.locked;
import com.martin.lc.locked.*;
public class AddictiveNumber {
	 public static boolean isAdditiveNumber(String num) {
	        if(num == null || num.length() < 3) return false;
	        return isAddictive(num,0,1,0L,0L);
	    }
	    
	    public static boolean isAddictive(String num, int index, int level, Long pprev, Long prev){
	        if(index == num.length()){
	            if(level > 3) return true;
	            else return false;
	        }else{
	        	if(num.charAt(index) == '0') return false;
	        	
	            if(level == 1 || level == 2){
	                for(int i=index;i<num.length();i++){
	                	String www = num.substring(index,i+1);
	                	try{
	                    long curVal = Long.parseLong(www);
	                    pprev = prev;
	                    //prev = curVal;
	                    if(isAddictive(num,i+1,level+1,pprev,curVal)) return true;
	                	}catch(Exception e){
	                		System.out.println(www);
	                	}
	                }
	            }else{
	            	if(pprev == 1L && prev == 99L){
	            		System.out.println("dsadasd");
	            	}
	                long lookingFor = pprev + prev;
	                String str = String.valueOf(lookingFor);
	                int nIndex = num.indexOf(str, index);
	                if( nIndex == index){
	                    //find that
	                    if(isAddictive(num,index+str.length(),level+1,prev,lookingFor)) return true;
	                }
	            }
	            return false;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean waha = isAdditiveNumber("11235813213455890144");
		MaxLenSubArraySumEqualK www = new MaxLenSubArraySumEqualK();
		www.haha = 2;
		System.out.println();
	}

}
