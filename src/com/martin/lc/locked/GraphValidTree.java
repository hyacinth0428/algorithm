package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 *
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 * 
 * Show Hint Note: you can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will
 * not appear together in edges.
 * 
 * Hide Company Tags Google Facebook Zenefits Show Tags Show Similar Problems
 * 
 * Solution:
 * 
 * For undirected graph, if edges is more than n-1 , then it must has cycle.
 * For n numbers of undirected graph, which would be formated in number of graphs, to make sure they are 
 * constructing a non-cycle graph:
 * 1.they should have n-1 edges
 * 2.from any node, we do a traversal there should not be a cycle
 * 3.if no cycle is detected, it may be the case that those nodes are constructing more than 1 graphs
 * so we need to track if any traversal can cover all nodes
 * 
 * For this problem , we can also use quick union to solve
 * quick union:
 * https://www.youtube.com/watch?v=Il3Ro8yGENE
 * 
 * */

public class GraphValidTree {
	// DFS, iterate through undirected graph
	public boolean validTree(int n, int[][] edges) {
		if (n == 0)
			return true;
		if (edges.length != n - 1)
			return false;
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i++)
			graph.put(i, new ArrayList<Integer>());
		for (int i = 0; i < edges.length; i++) {
			int first = edges[i][0];
			int sec = edges[i][1];
			graph.get(first).add(sec);
			graph.get(sec).add(first);
		}

		HashSet<Integer> visited = new HashSet<Integer>();
		if (dfs(0, -1, graph, visited))
			return false;
		return visited.size() == n;
	}

	public boolean dfs(int cur, int prev,
			HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited) {
		if (visited.contains(cur))
			return true;

		visited.add(cur);
		for (Integer it : graph.get(cur)) {
			if (it != prev) {
				if (dfs(it, cur, graph, visited))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
