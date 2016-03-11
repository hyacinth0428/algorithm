package com.martin.tree;

import com.martin.BasicData.TreeNode;

public class LargestBSTSubtree {
	public static class Node {
		public boolean valid;
		public int size;
		public Node(boolean valid, int size){
			this.valid = valid;
			this.size = size;
		}
	}
	public int largestBSTSubtree(TreeNode root) {
		if(root == null) return 0;
		return getLargestBST(root).size;
	}
	
	public Node getLargestBST(TreeNode root) {
		if(root == null) return new Node(true,0);
		if(root.left==null && root.right ==null) return new Node(true,1);
		Node left = getLargestBST(root.left);
		Node right = getLargestBST(root.right);
		if(root.left!=null && root.right!=null) {
			if(root.val>root.left.val && root.val <= root.right.val) {
				if(left.valid&&right.valid){
					return new Node(true,1+left.size+right.size);
				}else{
					int size =  Math.max(left.size, right.size);
					return new Node(false,size);
				}
			}else{
				int size = Math.max(left.size, right.size);
				return new Node(false,size);
			}
		}else{
			if(root.left==null){
				if(root.val <=root.right.val){
					return right.valid ? new Node(true,right.size+1):right;
				}else{
					right.valid = false;
					return right;
				}
			}else{
				if(root.val >root.left.val){
					return left.valid ? new Node(true,left.size+1):left;
				}else{
					left.valid = false;
					return left;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
