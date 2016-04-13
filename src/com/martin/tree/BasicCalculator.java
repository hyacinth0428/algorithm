package com.martin.tree;

import java.util.Stack;

/**
 * Created by Martin on 4/11/16.
 */
public class BasicCalculator {

    public static int calculate(String s) {
        int res = 0;
        if( s == null || s.length() == 0 ) return res;
        int i = s.length() -1;
        Stack<String> stk = new Stack<String>();
        while(i >= 0){
            char curChar = s.charAt(i);
            if(curChar == '-' || curChar == '+') {
                stk.push(s.substring(i,i+1));
                i--;
            }else if(curChar == ')'){
                stk.push(s.substring(i,i+1));
                i--;
            }else if(curChar == '('){
                int tmp = Integer.parseInt(stk.pop());
                while( !stk.peek().equals( ")") ){
                    String op = stk.pop();
                    Integer num = Integer.parseInt(stk.pop());
                    if(op.equals("-")){
                        tmp -= num;
                    }else{
                        tmp += num;
                    }
                }
                //pop the ( out
                stk.pop();
                stk.push(String.valueOf(tmp));
                i--;
            }else if (curChar == ' ') {
                i--;
            }else{
                int j = i-1;
                while(j >=0 && s.charAt(j) >= '0' && s.charAt(j) <= '9') j--;

                stk.push(s.substring(j+1,i+1));
                i=j;
            }
        }

            int tmp = Integer.parseInt(stk.pop());
            while( !stk.isEmpty() ){
                String op = stk.pop();
                Integer num = Integer.parseInt(stk.pop());
                if(op.equals("-")){
                    tmp -= num;
                }else{
                    tmp += num;
                }
            }

            res = tmp;


        return res;
    }


    public static void main(String[] args) {
        System.out.print(calculate("(1+(4+  5+2)-3)+(6+8)"));
    }
}
