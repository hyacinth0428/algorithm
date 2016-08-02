package com.martin.lc.locked;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        if(num==null || num.length() < 2) return true;
        int len = num.length();
        int start = 0;
        int end = len - 1;
        while(start<end){
            char first = num.charAt(start);
            char last = num.charAt(end);
            if( first == last){
                if( (first != '0') && (first != '1') && (first != '8')) 
                	return false;
            }else{
                if( first == '6'){
                	if(last!= '9') return false;
                }else if(first == '9'){
                	if(last!='6' ) return false;
                }else return false;
            }
            start ++;
            end --;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
