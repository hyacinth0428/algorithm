package com.martin.tree;

/**
 * Created by Martin on 3/23/16.
 */

public class SegmentTreeBuildII {

    public static  class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }

    public SegmentTreeNode build(int[] A) {
        if(A == null || A.length == 0) return null;
        return buildTree(A, 0, A.length-1);
    }

    public SegmentTreeNode buildTree(int[] A, int start, int end){
        if(start == end) return new SegmentTreeNode(start,end,A[start]);
        else{
            int mid = start + (end - start)/2;
            SegmentTreeNode  left = buildTree(A, start,mid);
            SegmentTreeNode  right = buildTree(A,mid+1,end);
            int max = Math.max(left.max,right.max);
            SegmentTreeNode res = new SegmentTreeNode(start,end,max);
            res.left = left;
            res.right = right;
            return res;
        }
    }
}
