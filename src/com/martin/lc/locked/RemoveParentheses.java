package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveParentheses {
	public int rightCnt = 0;
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        int pairsNeeded = mostPairs(s);
        HashSet<String> set = new HashSet<String>(); 
        getAll(set,s,0,pairsNeeded,0,0,this.rightCnt,new ArrayList<Character>());
        res = new ArrayList<String>(set);
        return res;
    }
    
    public String getStr(ArrayList<Character> buffer){
        StringBuilder  sb = new StringBuilder();
        for(int i=0;i<buffer.size();i++){
            sb.append(buffer.get(i));
        }
        return sb.toString();
    }
    
    public void getAll(HashSet<String> res, String s,int index, int pairsNeeded, int pairCnt, int leftIn, int rightR, ArrayList<Character> buffer){
        if(pairCnt == pairsNeeded || index == s.length()){
            if(pairCnt == pairsNeeded){
                res.add(getStr(buffer));
            }
        }else{
            char curChar = s.charAt(index++);
            if(curChar == '('){
                int pairN = pairsNeeded - pairCnt;
                getAll(res,s,index,pairsNeeded,pairCnt,leftIn,rightR,buffer);
                if(rightR >= pairN){
                    buffer.add(curChar);
                    leftIn ++;
                    getAll(res,s,index,pairsNeeded,pairCnt,leftIn,rightR,buffer);
                    buffer.remove(buffer.size()-1);
                }
            }else{
                if(curChar == ')'){
                    rightR--;
                    getAll(res,s,index,pairsNeeded,pairCnt,leftIn,rightR,buffer);
                    if(leftIn>0){
                        //no )
                        buffer.add(curChar);
                        leftIn--;
                        pairCnt++;
                        getAll(res,s,index,pairsNeeded,pairCnt,leftIn,rightR,buffer);
                        buffer.remove(buffer.size()-1);
                    }
                }else{
                    buffer.add(curChar);
                    getAll(res,s,index,pairsNeeded,pairCnt,leftIn,rightR,buffer);
                    buffer.remove(buffer.size()-1);

                }
            }
        }
    }
    
    public int mostPairs(String s){
        int cnt = 0;
        int leftCnt = 0;
        for(int i=0;i<s.length();i++){
            char curChar = s.charAt(i);
            if(curChar == '('){
                leftCnt++;
            }else{
                if(curChar == ')'){
                	rightCnt++;
                    if(leftCnt > 0){
                        cnt++;
                        leftCnt--;
                    }
                }
            }
        }
        return cnt;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveParentheses haha = new RemoveParentheses();
		List<String> res = haha.removeInvalidParentheses("(a)())()");
		System.out.println();
	}

}
