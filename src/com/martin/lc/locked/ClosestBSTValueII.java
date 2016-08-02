package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * Note: Given target value is a floating point. You may assume k is always
 * valid, that is: k ≤ total nodes. You are guaranteed to have only one unique
 * set of k values in the BST that are closest to the target. Follow up: Assume
 * that the BST is balanced, could you solve it in less than O(n) runtime (where
 * n = total nodes)?
 * 
 * Show Hint Hide Company Tags Google Show Tags Show Similar Problems
 * 
 * */
public class ClosestBSTValueII {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<Integer> inStk = new Stack<Integer>();
        Stack<Integer> rinStk = new Stack<Integer>();
        inorder(root,inStk,false,target);
        inorder(root,rinStk,true,target);
        while(k>0){
            if(inStk.isEmpty()) res.add(rinStk.pop());
            else if(rinStk.isEmpty()) res.add(inStk.pop());
            else{
                double d1 = Math.abs((double)inStk.peek() - target);
                double d2 = Math.abs((double)rinStk.peek() - target);
                if(d1<d2) res.add(inStk.pop());
                else res.add(rinStk.pop());
            }
            k--;
        }
        return res;
    }
    
    public void inorder(TreeNode root, Stack<Integer> stk, boolean reverse, double target){
        if(root==null) return;
        if(reverse)
            inorder(root.right,stk,reverse,target);
        else 
            inorder(root.left,stk,reverse,target);
        
        if(reverse && (double)root.val < target) return;
        if(!reverse && (double)root.val >= target) return;
        stk.push(root.val);
        if(reverse) inorder(root.left,stk,reverse,target);
        else inorder(root.right,stk,reverse,target);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
