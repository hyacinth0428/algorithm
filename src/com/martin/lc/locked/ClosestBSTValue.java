package com.martin.lc.locked;
/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Hide Company Tags Microsoft Google Snapchat
Show Tags
Show Similar Problems


Range!!! remember range of integer! Must consider it!
 * */
public class ClosestBSTValue {
	public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int nodeV = root.val;
        while(root!=null){
            double v = (double)root.val;
            double diff = Math.abs((double)root.val - target);
            if(diff < min){
                min = diff;
                nodeV = root.val;
            }
            if(v>target){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return nodeV;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
