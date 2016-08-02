package com.martin.lc.locked;

/**
 * Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
Hide Company Tags LinkedIn Facebook
Show Tags

 * */
public class SparseMatrixMul {
	public int[][] multiply(int[][] A, int[][] B) {
        if(A==null || B == null) return null;
        if(A.length == 0 || B.length == 0) return new int[0][0];
        int a  = A.length;
        int n = A[0].length;
        int n1 = B.length;
        int b = B[0].length;
        int[][] res = new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<n;j++){
               if(A[i][j]!=0){
                   int[] cur = new int[b];
                   for(int l = 0;l<b;l++) cur[l] = A[i][j]*B[j][l];
                   for(int k = 0;k<b;k++){
                       res[i][k] += cur[k];
                   }
               }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
