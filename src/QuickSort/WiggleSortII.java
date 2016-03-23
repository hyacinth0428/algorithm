package QuickSort;

public class WiggleSortII {
	
	public static void wiggleSort(int[] nums) {
        // Write your code here
		if(nums == null || nums.length <2 ) return;
		int len = nums.length;
		int k = len /2;
		int pivot = findKthMax(nums,0,nums.length-1,k);
		int i = 0;
		int j = len-1;
		//the index max should stop
		int mid_index = len%2==0? len/2:len/2+1;
		int[] tmp = new int[len];
		for(int r = 0;r<len;r++) {
			if(nums[r] < pivot) tmp[i++] = nums[r];
			
			if(nums[r] > pivot) tmp[j--] = nums[r];
		}
		
		while(i < mid_index){
			tmp[i++] = pivot;
		}
		
		while(j >= mid_index){
			tmp[j--] = pivot;
		}
		
		for(int s = 0;s<mid_index;s++){
			nums[s*2] = tmp[s];
		}
		
		for(int s = mid_index;s<nums.length;s++){
			nums[(s-mid_index)*2+1] = tmp[s];
		}
    }
	
	public static int findKthMax(int[] nums, int start,int end, int k) {
		int head = start;
		int tail = end;
		int pivot = nums[start];
		
		while(head <= tail){
			while( head <= tail && nums[head] >= pivot ){
				head ++;
			}
			
			while( head <= tail && nums[tail] < pivot) {
				tail--;
			}
			
			while(tail > head){
				int tmp = nums[head];
				nums[head] = nums[tail];
				nums[tail] = tmp;
				tail--;
				head++;
			}
		}
		
		//How many numbers are larger than pivot
		int size = head - start -1;
		
		//stop
		if(size == k-1) return pivot;
		
		if(head == start+1){
			return findKthMax(nums,head,end,k-1);
		}else if(head == end +1){
			return findKthMax(nums,start+1,end,k);
		}else if(size > k-1){
			return findKthMax(nums,start,head-1,k);
		}else{
			return findKthMax(nums,head,end,k-size-1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = {1, 3, 2, 2, 3, 1};
		wiggleSort(ary);
		System.out.println();
	}

}
