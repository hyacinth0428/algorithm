package com.martin.lc.locked;
/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?

Hide Company Tags Zenefits
Show Tags
Show Similar Problems

 * */

public class VerifyPreorderTraversal {
	  public int index = 0;
	  public boolean verifyPreorder(int[] preorder) {
	       	if(preorder == null || preorder.length <= 1) return true;
	       	goThrough(preorder,Integer.MIN_VALUE, Integer.MAX_VALUE);
	       	return index == preorder.length;   
	      }

	  public void goThrough(int[] preorder,int small, int large){
	  	int now = preorder[index];
	  	if( now > small && now < large){
	  	    index ++;
	  		if(index < preorder.length && preorder[index] < now){
	  			goThrough(preorder,small,now);
	  		}
	          
	  		if(index < preorder.length && preorder[index] > now){
	  			goThrough(preorder,now,large);
	  		}
	  	}
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
