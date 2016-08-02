package com.martin.lc.locked;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Hide Company Tags LinkedIn
Show Tags
Show Similar Problems

 * */
public class PaintHouses {
	public static class Node{
        public int[] cost;
        public Node(){
            this.cost = new int[3];
        }
        public int minCost(){
            return Math.min(cost[0], Math.min(cost[1],cost[2]));
        }
    }
    
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int len = costs.length;
        Node[] f = new Node[len];
        f[0] = new Node();
        f[0].cost = costs[0];
        for(int i=1;i<len;i++){
            f[i] = new Node();
            f[i].cost[0] = costs[i][0] + Math.min(f[i-1].cost[1], f[i-1].cost[2]);
            f[i].cost[1] = costs[i][1] + Math.min(f[i-1].cost[0], f[i-1].cost[2]);
            f[i].cost[2] = costs[i][2] + Math.min(f[i-1].cost[0], f[i-1].cost[1]);
        }
        return f[len-1].minCost();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
