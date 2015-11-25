package com.martin.AdvancedDatasStructure;

public class NumArray {
	
	public static class Node {
		public int start;
		public int end;
		public int sum;
		public Node left,right;
		
		public Node(int start, int end,int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
			this.left = null;
			this.right = null;
		}
	}
	
	public Node root;
	public int size = 0 ;
	public NumArray(int[] nums) {
		if(nums != null && nums.length != 0) {
			this.size = nums.length;
			this.root = buildTree(nums,0,nums.length-1);
		}
	}
	
	public Node buildTree(int[] nums,int start, int end) {
		if(start == end) {
			return new Node(start, end, nums[start]);
		}else{
			int mid = start +(end-start)/2;
			Node left = buildTree(nums,start,mid);
			Node right = buildTree(nums,mid+1,end);
			Node cur = new Node(start,end,left.sum+right.sum);
			cur.left = left;
			cur.right = right;
			return cur;
		}
	}
	
	public void updateSegmentTree(Node root,int index,int val) {
		if(index == root.start && index == root.end){
			root.sum = val;
		}else{
			int mid = root.start + (root.end - root.start)/2; 
			if( index <= mid){
				updateSegmentTree(root.left,index,val);
			}else{
				updateSegmentTree(root.right,index,val);
			}
			
			root.sum = root.left.sum + root.right.sum;
		}
	}
	
	void update(int i, int val) {
		if(i<0 || i >= size) return;
		updateSegmentTree(root,i,val);
	}

	public int sumRange(int i, int j) {
		if(i<0) i=0;
		if(j>=size) j=size-1;
		return searchInSegmentTree(root,i,j);
	}
	
	public int searchInSegmentTree(Node root, int start, int end) {
		if(root.start == start && root.end == end){
			return root.sum;
		}else{
			int mid = root.start + (root.end - root.start)/2;
			if(end <= mid){
				return searchInSegmentTree(root.left,start,end);
			}else if(start > mid){
				return searchInSegmentTree(root.right,start,end);
			}else{
				return searchInSegmentTree(root.left,start,mid) + searchInSegmentTree(root.right,mid+1,end);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
