package com.martin.lc.locked;

import java.util.Arrays;

public class CountRangeSum {
	 public static class SegmentTreeNode{
	        public int small;
	        public int large;
	        public int cnt;
	        public SegmentTreeNode left,right;
	        public SegmentTreeNode(int s, int l){
	            this.small = s;
	            this.large = l;
	            this.cnt = 0;
	            this.left = this.right = null;
	        }
	    }
	    
	    SegmentTreeNode root;
	    //build empty tree
	    public SegmentTreeNode buildTree(int small, int large){
	        if(small == large) return new SegmentTreeNode(small,small);
	        SegmentTreeNode now = new SegmentTreeNode(small, large);
	        int mid = small + (large - small)/2;
	        SegmentTreeNode left =buildTree(small, mid);
	        SegmentTreeNode right = buildTree(mid+1,large);
	        now.left = left;
	        now.right = right;
	        return now;
	    }
	    
	    public void update(SegmentTreeNode root, int val){
	        if(root == null) return;
	        if( val >= root.small && val <= root.large){
	            root.cnt++;
	            int mid = root.small + (root.large-root.small)/2;
	            if(val <= mid) update(root.left,val);
	            else update(root.right,val);
	        }
	    }
	    
	    public int search(SegmentTreeNode root, int low, int high){
	        if( root == null) return 0;
	        if( low <= root.small && high >= root.large) return root.cnt;
	        else{
	            int mid = root.small + (root.large - root.small)/2;
	            if(high <= mid) return search(root.left, low, high);
	            else if( low > mid) return search(root.right,low,high);
	            else return search(root.left,low, mid) + search( root.right, mid+1, high);
	        }
	    }
	    
	    public int countRangeSum(int[] nums, int lower, int upper) {
	        if(nums == null || nums.length == 0 || lower > upper ) return 0;
	        int len  = nums.length;
	        int[] sum = new int[len];
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        int total = 0;
	        for(int i=0 ;i <len;i++){
	            if(i==0) sum[i] = nums[i];
	            else sum[i] = nums[i] + sum[i-1];
	            total = sum[i];
	            min = Math.min(min,total);
	            max = Math.max(max,total);
	        }
	        int res = 0;
	        root = buildTree(min,max);
	        for(int i=len-1;i>=0;i--){
	            update(this.root,total);
	            total -= nums[i];
	            res += search(this.root,lower+total,upper+total);
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountRangeSum w = new CountRangeSum();
		int[] ary = {-1,5,-2};
		w.countRangeSum(ary,-2,2);
		int[][] aa =new int[2][3];
		Arrays.fill(aa, 1);
	}

}
