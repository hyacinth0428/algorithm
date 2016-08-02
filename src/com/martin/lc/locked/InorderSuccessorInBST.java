package com.martin.lc.locked;
/**
 * 
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Hide Company Tags Pocket Gems Microsoft Facebook
Show Tags
Show Similar Problems

 * */

public class InorderSuccessorInBST {
	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        if(root == null || p==null) return null;
	        
	        //if has right node
	        if(p.right!=null){
	            TreeNode right = p.right;
	            while(right.left!=null) right = right.left;
	            return right;
	        }else{
	            //if p is at the left side of its root
	            TreeNode larger = null;
	           
	            while(root!=null){
	                if(root==p) {
	                    return larger;
	                }else if(root.val < p.val){
	                    root = root.right;
	                }else{
	                    larger = root;
	                    root = root.left;
	                }
	            }
	            return null;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
