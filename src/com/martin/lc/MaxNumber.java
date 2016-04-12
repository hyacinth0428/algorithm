package com.martin.lc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.*;

/**
 * Created by Martin on 3/15/16.
 */
public class MaxNumber {

    public static class Node {
        int curMax;
        int curIndex;
        int len;
        HashMap<Integer,Queue<Integer>> status;
        public Node() {
            this.curIndex =0;
            this.len = 0;
            this.curMax = 0;
            this.status = new HashMap<Integer,Queue<Integer>>();
        }
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1 == null && nums2 == null) return null;
        if(nums1 == null ) return maxNumber(new int[0],nums2,k);
        if(nums2 == null ) return maxNumber(nums1,new int[0],k);
        Node content1 = new Node();
        Node content2 = new Node();
        buildStatusNode(nums1,content1);
        buildStatusNode(nums2,content2);
        return null;
    }

    public ArrayList<Integer> getMax(Node content1, Node content2, int k) {
        if( k == 0 ){
            return new ArrayList<Integer>();
        }

        if(content1.len - content1.curIndex + content2.len - content2.curIndex < k) return null;
        // update status based on curIndex
        while(content1.curMax >=0 ){
            if(!content1.status.containsKey(content1.curMax)) {
                content1.curMax --;
                continue;
            }

            if( content1.status.get(content1.curMax).peek() > content1.curIndex) break;
            else{
                content1.status.get(content1.curMax).poll();
                if(content1.status.get(content1.curMax).isEmpty()){
                    content1.status.remove(content1.curMax);
                    content1.curMax --;
                }
            }
        }

        while(content2.curMax >=0 ){
            if(!content2.status.containsKey(content2.curMax)) {
                content2.curMax --;
                continue;
            }

            if( content2.status.get(content2.curMax).peek() > content2.curIndex) break;
            else{
                content2.status.get(content2.curMax).poll();
                if(content2.status.get(content2.curMax).isEmpty()){
                    content2.status.remove(content2.curMax);
                    content2.curMax --;
                }
            }
        }

        return null;
    }

    public void buildStatusNode(int[] ary , Node content) {
        int max = 0;
        for(int i = 0;i <ary.length;i++) {
            int curVal = ary[i];
            max = Math.max(curVal,max);
            if(content.status.containsKey(curVal)) {
                content.status.get(curVal).offer(i);
            }else{
                Queue<Integer> tmp = new LinkedList<Integer>();
                tmp.offer(i);
                content.status.put(curVal,tmp);
            }
        }
        content.len = ary.length;
        content.curMax = max;
    }
}
