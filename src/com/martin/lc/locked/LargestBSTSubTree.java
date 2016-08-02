package com.martin.lc.locked;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Show Hint 
Follow up:
Can you figure out ways to solve it with O(n) time complexity?

Hide Company Tags Microsoft
Show Tags

 * */

//ZHU YI: not only compare root to right/left, also root to min in righ and max in left
public class LargestBSTSubTree {
	 public static class Stat{
	        public boolean isBST;
	        public int maxSize;
	        public int min = Integer.MAX_VALUE;
	        public int max = Integer.MIN_VALUE;
	        public Stat(int max,boolean isBST){
	            this.maxSize = max;
	            this.isBST = isBST;
	        }
	    }
	    public int largestBSTSubtree(TreeNode root) {
	        if(root == null) return 0;
	        return find(root).maxSize;
	    }
	    
	    public boolean inRange(int min, int max, int v){
	        return v > min && v < max;
	    }
	    //rethink null as corner case
	    public Stat find(TreeNode root){
	        if(root == null) return new Stat(0,true);
	        Stat  left = find( root.left );
	        Stat right = find( root.right );
	        if(left.isBST && right.isBST){
	            //check if I am a bst
	            if( (root.left == null || (root.val > root.left.val && root.val > left.max)) && 
	                (root.right == null || (root.val < root.right.val && root.val < right.min))) {
	                Stat res = new Stat(left.maxSize + right.maxSize + 1, true);
	                res.min = Math.min(root.val, left.min);
	                res.max = Math.max(root.val, right.max);
	                return res;
	            }else{
	                return new Stat(Math.max(1,Math.max(left.maxSize,right.maxSize)) , false);
	            }
	        }else{
	            //not bst
	            return new Stat(Math.max(1,Math.max(left.maxSize,right.maxSize)) , false);
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "11".substring(3,2);
		System.out.println(s);
	}

}
