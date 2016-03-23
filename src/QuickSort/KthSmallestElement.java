package QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

//We will have both kth largest and smallest in here
public class KthSmallestElement {
    
	public static int kthLargestElement(int k, int[] numbers) {
		if(numbers == null || numbers.length == 0) return 0;
		int len = numbers.length;
		if(len < k) return 0;
		return getKth(numbers,0,len-1,k);
	}
	
	public static int getKth(int[] numbers, int start, int end, int k){
		int head = start;
		int tail = end;
		int pivot = numbers[start];
		
		while(head <= tail ){
			while(head<=tail && numbers[head] >= pivot){
				head++;
			}
			
			while(tail >= head && numbers[tail] < pivot){
				tail--;
			}
			
			if(tail >= head){
				int tmp = numbers[head];
				numbers[head] = numbers[tail];
				numbers[tail] = tmp;
				tail--;
				head++;
			}
		}
		
		//how many numbers larger than pivot
		int size = head - start -1;
		if(size == k-1) return pivot;
		if(size == 0) return getKth(numbers,head,end,k-1);
		else if (head == end + 1){
			return getKth(numbers,start+1,end,k);
		}else if (size > k-1){
			return getKth(numbers,start,head-1,k);
		}else{
			return getKth(numbers,head,end,k-size-1);
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = {9,3,2,4,8};
 		ArrayList<Integer> numbers = new ArrayList<Integer>();
 		for(int i=0;i<ary.length;i++) numbers.add(ary[i]);
 		System.out.println(kthLargestElement(3,ary));
	}

}
