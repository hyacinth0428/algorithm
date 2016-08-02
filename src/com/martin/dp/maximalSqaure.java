package com.martin.dp;

public class maximalSqaure {
	 public static class Node {
	        public int up;
	        public int left;
	        public boolean valid;
	        public Node(int up, int left,boolean vali){
	            this.up = up;
	            this.left = left;
	            this.valid = vali;
	        }
	    }
	    public static int maximalSquare(char[][] matrix) {
	        if(matrix == null || matrix.length ==0) return 0;
	        int height = matrix.length;
	        int width = matrix[0].length;
	        Node[][] f = new Node[height][width];
	        int max = 0;
	        for(int i=0;i<height;i++){
	            for(int j=0;j<width;j++){
	                if(matrix[i][j] == '1'){
	                    max = Math.max(1,max);
	                    f[i][j] = new Node(i,j,true);
	                   
	                    if(i>0){
	                        if(f[i-1][j].valid) f[i][j].up = f[i-1][j].up;
	                    }
	                    if(j>0){
	                        if(f[i][j-1].valid) f[i][j].left = f[i][j-1].left;
	                    }
	                    if( i>0 && j>0 && f[i-1][j-1].valid){
	                        int left = Math.max(f[i][j].left, f[i-1][j-1].left);
	                        int up = Math.max(f[i][j].up,f[i-1][j-1].up);
	                        int edge = Math.min(j-left +1, i-up+1);
	                        if(edge == 3){
	                        	Node haha = f[i][j];
	                        	Node haha1 = f[i-1][j-1];
	                        	Node haha2 = f[i][j-1];
	                        	System.out.println();
	                        }
	                        max = Math.max(max,edge*edge);
	                    }
	                }else{
	                    f[i][j] = new Node(-1,-1,false);
	                }
	            }
	        }
	        for(int i=0;i<height;i++){
	        	for(int j=0;j<width;j++){
	        		System.out.print(f[i][j].valid + " ");
	        	}
	        	System.out.print("\n");
	        }
	        return max;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] cAry = {"101001110".toCharArray(),
				   "111000001".toCharArray(),
				   "001100011".toCharArray(),
				   "011001001".toCharArray(),
				   "110110010".toCharArray(),
				   "011111101".toCharArray(),
				   "101110010".toCharArray(),
				   "111010001".toCharArray(),
				   "011110010".toCharArray(),
				   "100111000".toCharArray()};
		int a = maximalSquare(cAry);
	}

}
