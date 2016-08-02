package com.martin.tree;

import java.util.Stack;

public class BasicCalculatorII {
	public static int calculate(String s) {
        if(s==null || s.length() == 0) return 0;
        int len = s.length();
        Stack<String> stk = new Stack<String>();
        int start = 0;
        while(start < len){
            char curChar = s.charAt(start);
            if(curChar == ' ') start++;
            else{
                if(curChar == '+' || curChar == '-'){
                    stk.push(s.substring(start,start+1));
                    start++;
                }else if(curChar == '*' || curChar == '/'){
                    //need to calculate
                    int start1 = start+1;
                    while(s.charAt(start1) == ' ') start1++;
                    int end1 = start1+1;
                    while(end1 < len ){
                    	if(s.charAt(end1) >='0' && s.charAt(end1) <='9')end1++;
                    	else break;
                    }
                    int numNow = Integer.parseInt(s.substring(start1,end1));
                    int numPrev = Integer.parseInt(stk.pop());
                    if(curChar == '*') stk.push(String.valueOf(numNow*numPrev));
                    else stk.push(String.valueOf(numPrev/numNow));
                    start= end1;
                }else{
                    int end1 = start+1;
                    while(end1 < len ){
                    	if(s.charAt(end1) >='0' && s.charAt(end1) <= '9') end1++;
                    	else break;
                    }
                    stk.push(s.substring(start,end1));
                    start = end1;
                }
            }
        }
        
        return calStk(stk);
    }
    
    public static int calStk(Stack<String> stk){
        int res = 0;
        while(!stk.isEmpty()){
            String now = stk.pop();
            if(stk.isEmpty() || stk.pop().equals("+")){
                res += Integer.parseInt(now);
            }else{
                res -= Integer.parseInt(now);
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculate(" 3+5 / 2 *2 +3/1"));
	}

}
