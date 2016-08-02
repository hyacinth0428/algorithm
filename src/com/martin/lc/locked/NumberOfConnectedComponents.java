package com.martin.lc.locked;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 Google
 * */
public class NumberOfConnectedComponents {
	public int countComponents(int n, int[][] edges) {
        if(n<0) return 0;
        if(n==1) return 1;
        if(edges == null || edges.length == 0) return n;
        int[] uf = new int[n];
        for(int i=0;i<n;i++) uf[i] = i;
        int cnt = n;
        
        for(int i=0;i<edges.length;i++){
            int first = edges[i][0];
            int sec = edges[i][1];
            int head1 = findHead(uf,first);
            int head2 = findHead(uf,sec);
            if(head1 != head2){
                cnt--;
                uf[head2] = head1;
            }
        }
        
        return cnt;
    }
    
    public int findHead(int[] uf, int index){
        while(uf[index] != index){
            index = uf[index];
        }
        return index;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
