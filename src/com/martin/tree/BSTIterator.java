package com.martin.tree;

import java.util.Stack;

/**
 * Created by Martin on 4/11/16.
 */
public class BSTIterator {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        this.stk = new Stack<TreeNode>();
        add(root);
    }

    public void add(TreeNode root) {
        while(root!=null) {
            this.stk.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext()) return -1;
        TreeNode curNode = this.stk.pop();
        add(curNode.right);
        return  curNode.val;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(2);
        System.out.println();
    }
}
