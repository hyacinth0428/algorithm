package com.martin.lc.locked;

public class NumMatrix {
	private int[][] sums;
    private int height;
    private int width;
    public NumMatrix(int[][] matrix) {
        if(matrix!=null && matrix.length!=0){
             height = matrix.length;
             width = matrix[0].length;
            sums = new int[height][width];
            sums[0][0] = matrix[0][0];
            for(int i=1;i<width;i++) sums[0][i] = matrix[0][i] + sums[0][i-1];
            for(int i=1;i<height;i++) sums[i][0] = matrix[i][0] + sums[i-1][0];
            for(int i=1;i<height;i++){
                for(int j=1;j<width;j++){
                    sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
                }
            }
        }
    }
    
    public void printM(int[][] m){
    	for(int i=0;i<height;i++){
    		for(int j=0;j<width;j++){
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
    public void update(int row, int col, int val) {
        int prev = sumRegion(row,col,row,col);
        printM(sums);
        int diff = val - prev;
        for(int i=row;i<height;i++){
            for(int j=col;j<width;j++){
                sums[i][j] += diff;
            }
        }
        printM(sums);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int v1 = sums[row2][col2];
        int v2 = row1 == 0 ? 0 : sums[row1 - 1][col2];
        int v3 = col1 == 0 ? 0 : sums[row2][col1 - 1];
        int v4 = (row1 >0 && col1 >0) ? sums[row1-1][col1-1] : 0;
        return v1 - v2 - v3 + v4;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = {
		                {3, 0, 1, 4, 2},
		                {5, 6, 3, 2, 1},
		                {1, 2, 0, 1, 5},
		                {4, 1, 0, 1, 7},
		                {1, 0, 3, 0, 5}
		                };
		NumMatrix my = new NumMatrix(data);
		System.out.println(my.sumRegion(2, 1, 4, 3));// -> 8
		my.update(3, 2, 2);
		System.out.println(my.sumRegion(2, 1, 4, 3));// -> 10
	}
	
}
