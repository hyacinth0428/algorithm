package com.martin.AdvancedDatasStructure;

/**
 * If the matrix is mutable, then 2d Segment tree should be it
 * */
public class NumMatrix {
	protected int[][] sumMatrix;
    protected int height;
    protected int width;
    
    public NumMatrix(int[][] matrix) {
        if( matrix != null && matrix.length!=0) {
            height = matrix.length;
            width = matrix[0].length;
            sumMatrix = new int[height][width];
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    if(i==0 || j==0) {
                        if(i==0 && j==0) {
                            sumMatrix[i][j] = matrix[i][j];
                        }else if(i==0) {
                            sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j-1];
                        }else{
                            sumMatrix[i][j] = matrix[i][j] + sumMatrix[i-1][j];   
                        }
                    }else{
                        sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j-1] + sumMatrix[i-1][j] - sumMatrix[i-1][j-1];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sumMatrix==null) return -1;
        
        int cnt=0;
        int up=0;
        int left=0;
        if(row1>0){
            cnt++;
            up = sumMatrix[row1-1][col2];
        }
        
        if(col1>0){
            cnt++;
            left = sumMatrix[row2][col1-1];
        }
        
        int res= sumMatrix[row2][col2] - up - left;
        return (cnt==2) ? res + sumMatrix[row1-1][col1-1]: res; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {
		             {3, 0, 1, 4, 2},
		             {5, 6, 3, 2, 1},
		             {1, 2, 0, 1, 5},
		             {4, 1, 0, 1, 7},
		             {1, 0, 3, 0, 5}
		             };
		
		NumMatrix worker = new NumMatrix(m);
		System.out.println(worker.sumRegion(2, 1, 4, 3));
		System.out.println(worker.sumRegion(1, 1, 2, 2));
		System.out.println(worker.sumRegion(1, 2, 2, 4));
	}

}
