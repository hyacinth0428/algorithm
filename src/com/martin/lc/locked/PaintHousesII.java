package com.martin.lc.locked;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?

Hide Company Tags Facebook
Show Tags
Show Similar Problems

 * */
public class PaintHousesII {
	public static class Node{
        public int[] cost;
        public Node(int k){
            this.cost = new int[k];
        }
        public int minCost(){
            int min = Integer.MAX_VALUE;
            for(int i=0;i<cost.length;i++){
                min = Math.min(min,cost[i]);
            }
            return min;
        }
        public int minExcept(int index){
            int min = Integer.MAX_VALUE;
            for(int i=0;i<cost.length;i++){
                if(i!=index)
                    min = Math.min(min,cost[i]);
            }
            return min;
        }
    }
    
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int len = costs.length;
        int k = costs[0].length;
        Node[] f = new Node[len];
        f[0] = new Node(k);
        f[0].cost = costs[0];
        for(int i=1;i<len;i++){
            f[i] = new Node(k);
            for(int j =0;j<k;j++){
                f[i].cost[j] = costs[i][j] + f[i-1].minExcept(j);
            }
        }
        return f[len-1].minCost();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
