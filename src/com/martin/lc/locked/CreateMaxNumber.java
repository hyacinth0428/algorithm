package com.martin.lc.locked;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]

google
 * */
public class CreateMaxNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1==null || nums2==null) return null;
        if(k<=0) return new int[0];
        int[] res = new int[k];
        int len1 = nums1.length;
        int len2 = nums2.length;
        //nums1 use i num of things
        for(int i=0;i<=k;i++){
            if(i>len1)break;
            int j = k - i;
            //make sure we can have something in nums2
            if(j<0 || j > len2) continue;
            int[] ary1 = getMax(nums1,i);
            int[] ary2 = getMax(nums2,j);
            
            int[] tmp = new int[k];
            int m = 0;
            int n = 0;
            int index = 0;
            while( m<ary1.length && n < ary2.length){
                if(ary1[m] != ary2[n]){
                    tmp[index++] = ary1[m] > ary2[n] ? ary1[m++]:ary2[n++];
                }else{
                    tmp[index++] = compareAry(ary1, m+1, ary2,n+1) ? ary1[m++] : ary2[n++];
                }
            }
            while(m<ary1.length) tmp[index++] = ary1[m++];
            while(n<ary2.length) tmp[index++] = ary2[n++];
            if(compareAry(tmp,0,res,0)) res = tmp;
        }
        return res;
    }
    
	//Important part
    public boolean compareAry(int[] ary1, int index1, int[] ary2, int index2){
        while(index1 < ary1.length && index2 < ary2.length){
            if(ary1[index1] < ary2[index2]) return false;
            if(ary1[index1] > ary2[index2]) return true;
            index1++;
            index2++;
        }
        return index1 == ary1.length ? false: true;
    }
    public int[] getMax(int[] ary,int size){
        if(size == 0) return new int[0];
        int[] res = new int[size];
        int index = 0;
        for(int i=0;i<ary.length;i++){
            int curVal = ary[i];
            if(index==0) res[index++] = curVal;
            else{
                //index -> next add, so check index - 1 as last one
                while(index >0){
                    if(curVal > res[index-1]){
                        //make sure we have enough back there 
                        if(ary.length-i >= size - index + 1) index--;
                        else break;
                    }else break;
                }
                if(index < size) res[index++] = curVal;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary1 = {3,4,6,5};
		int[] ary2 = {9,1,2,5,8,3};
		CreateMaxNumber cmn = new CreateMaxNumber();
		cmn.maxNumber(ary1, ary2, 5);
		ary1 = ary2;
		System.out.println();
	}

}
