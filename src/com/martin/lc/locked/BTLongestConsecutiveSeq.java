package com.martin.lc.locked;

/**
 * Given a binary tree, find the length of the longest consecutive sequence
 * path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The longest consecutive path
 * need to be from parent to child (cannot be the reverse).
 * 
 * For example, 1 \ 3 / \ 2 4 \ 5 Longest consecutive sequence path is 3-4-5, so
 * return 3. 2 \ 3 / 2 / 1 Longest consecutive sequence path is 2-3,not3-2-1, so
 * return 2.
 * 
 * Google
 * */
public class BTLongestConsecutiveSeq {
	public static class Node {
		public int longestWithMe;
		public int longest;
		public Node(int lwm, int l) {
			this.longestWithMe = lwm;
			this.longest = l;
		}
	}

	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return findLongest(root).longest;
	}

	public Node findLongest(TreeNode root) {
		if (root == null)
			return new Node(0, 0);
		Node left = findLongest(root.left);
		Node right = findLongest(root.right);
		// with me
		if (root.left == null && root.right == null)
			return new Node(1, 1);
		else {
			if (root.right == null) {
				if (root.val == root.left.val - 1) {
					int maxWithMe = 1 + left.longestWithMe;
					int max = Math.max(left.longest, maxWithMe);
					return new Node(maxWithMe, max);
				} else
					return new Node(1, Math.max(1, left.longest));
			} else if (root.left == null) {
				if (root.val == root.right.val - 1) {
					int maxWithMe = 1 + right.longestWithMe;
					int max = Math.max(right.longest, maxWithMe);
					return new Node(maxWithMe, max);
				} else
					return new Node(1, Math.max(1, right.longest));
			} else {
				int maxWithMe = 1;
				int max = 1;
				if (root.val == root.right.val - 1
						&& root.val == root.left.val - 1) {
					maxWithMe = 1 + Math.max(left.longestWithMe,
							right.longestWithMe);
					max = Math.max(Math.max(left.longest, right.longest),
							maxWithMe);
				} else if (root.val == root.right.val - 1) {
					maxWithMe = 1 + right.longestWithMe;
					max = Math.max(Math.max(left.longest, right.longest),
							maxWithMe);
				} else if (root.val == root.left.val - 1) {
					maxWithMe = 1 + left.longestWithMe;
					max = Math.max(Math.max(left.longest, right.longest),
							maxWithMe);
				} else {
					max = Math.max(1, Math.max(left.longest, right.longest));
				}
				return new Node(maxWithMe, max);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
