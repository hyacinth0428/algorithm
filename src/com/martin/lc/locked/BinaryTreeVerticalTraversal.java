package com.martin.lc.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
Hide Company Tags Google Snapchat Facebook
Show Tags
Show Similar Problems

 * */
public class BinaryTreeVerticalTraversal {
	 public HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
	    public int min = 0;
	    public int max = 0;
	    
	    public static class Node{
	        public int val;
	        public TreeNode node;
	        public Node(int val, TreeNode r){
	            this.val = val;
	            this.node = r;
	        }
	    }
	    
	    public List<List<Integer>> verticalOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(root==null) return res;
	        Queue<Node> queue = new LinkedList<Node>();
	        queue.offer(new Node(0,root));
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i=0;i<size;i++){
	                Node curNode = queue.poll();
	                min = Math.min(min,curNode.val);
	                max = Math.max(max, curNode.val);
	                if(!map.containsKey(curNode.val)) map.put(curNode.val , new ArrayList<Integer>());
	                map.get(curNode.val).add(curNode.node.val);
	                if(curNode.node.left!=null) queue.offer(new Node(curNode.val-1, curNode.node.left));
	                if(curNode.node.right!=null) queue.offer(new Node(curNode.val+1, curNode.node.right));
	            }
	        }
	        
	        for(int i=min;i<=max;i++){
	            res.add(map.get(i));
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
