package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
	 public List<String> addOperators(String num, int target) {
	        List<String> res = new ArrayList<String>();
	        if(num == null || num.length() ==0) return res;
	        dfs(res,0,0,"",num,(long)target);
	        return res;
	    }
	    
	    //last -> last operatable value
	    public void dfs(List<String> res, long cur, long last, String str, String num, long target){
	        if( num.length() == 0){
	            if(cur == target)
	                res.add(str);
	        }else{
	            for(int i=1;i<=num.length();i++){
	                String curStr = num.substring(0,i);
	                if(curStr.charAt(0) == '0') return;
	                String next = num.substring(i);
                    long curVal = Long.parseLong(curStr);
	                if(str.length() > 0){
	                    //+
	                    dfs(res, cur+curVal, curVal,str + "+" + curStr, next,target );
	                    //-
	                    dfs(res, cur-curVal, -curVal, str + "-" + curStr, next, target);
	                    //*
	                    dfs(res, cur-last + last*curVal, last*curVal, str + "*" + curStr, next, target);
	                }else{
	                    //+ only
	                    dfs(res, cur+curVal, curVal, curStr, next, target);
	                }
	            }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
