package com.martin.lc.locked;

public class WiggleSortII {
//	System.out.println(mid);
//    int i = 0, j = 0, k = len - 1;
//    while (j <= k) {
//     if (nums[j] > mid){
//        swap(nums,i,j);
//        i++;
//        j++;
//     }
//    else if (nums[j] < mid){
//        swap(nums,j,k);
//        k--;
//    }
//    else
//        j++;
//    }
//    for(int ik =0;ik<nums.length;ik++)
//        System.out.print(nums[ik] + " ");
//    
//    System.out.println();
//    int sEnd = (len-1)/2;
//    reverse(nums,0,len-1);
//    reverse(nums,0,sEnd);
//    for(int ik =0;ik<nums.length;ik++)
//        System.out.print(nums[ik] + " ");
//    int head = 1;
//    int tail = ((len - 1) %2 == 0) ? len-1: len-2;
//    while( head < tail){
//        int tmp = nums[head];
//        nums[head] = nums[tail];
//        nums[tail] = tmp;
//        head +=2;
//        tail -=2;
//    }
	public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <=1) return;
        int len = nums.length;
        int mid = findKthMax(nums, 0, len -1, 1 + (len-1)/2);
        
        int i = 0;
        int j = len - 1;
        while( i <= j){
            while( i <= j){
                if( nums[i] <= mid) i++;
                else break;
            }
            while(i<=j){
                if( nums[j] > mid) j--;
                else break;
            }
            if( i<=j ){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        int sEnd = (len-1)/2;
        swap(nums,0,sEnd);
        int head = 1;
        int tail = ((len - 1) %2 == 0) ? len-1: len-2;
        while( head < tail){
            int tmp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = tmp;
            head +=2;
            tail -=2;
        }
    }
    public void swap(int[] ary, int start, int end){
        while(start < end){
            int tmp = ary[start];
            ary[start] = ary[end];
            ary[end] = tmp;
            start++;
            end--;
        }
    }
    
    public int findKthMax(int[] nums, int start, int end, int k){
        int i = start;
        int j = end;
        int pivot = nums[start];
        
        while( i<=j ){
            while(i<=j){
                if(nums[i] > pivot)i++;
                else break;
            }
            while(i<=j){
                if(nums[j] <= pivot)j--;
                else break;
            }
            if(i<=j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        
        int largerThan = i - start;
        if(largerThan == k-1) return pivot;
        //extreme
        //noone larger -> looking for k-1 largest
        if( i == start) return findKthMax(nums,i+1,end,k-1);
        if(largerThan > k-1) return findKthMax(nums,start,i-1,k);
        else return findKthMax(nums,i,end,k-largerThan);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
