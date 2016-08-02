package com.martin.lc.locked;

/**
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
 * */
public class CountUniTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static class Stat{
        public int uniTreeCnt;
        public boolean isUni;
        public int uniVal;
        public Stat(int uniTreeCnt, int uniVal, boolean isUni){
            this.uniTreeCnt = uniTreeCnt;
            this.uniVal = uniVal;
            this.isUni = isUni;
        }
    }
    
    public int countUnivalSubtrees(TreeNode root) {
       if(root == null) return 0;
       return getAll(root).uniTreeCnt;
    }
    
    public Stat getAll(TreeNode root){
        if(root == null) return null;
        Stat left = getAll(root.left);
        Stat right = getAll(root.right);
        if(left==null && right ==null){
            return new Stat(1,root.val,true);
        }else{
            if(left==null){
                if(right.isUni){
                    if(root.val == right.uniVal) return new Stat(right.uniTreeCnt+1,right.uniVal,true);
                    else return new Stat(right.uniTreeCnt,right.uniVal,false);
                }else return new Stat(right.uniTreeCnt,right.uniVal,false);
            }else if(right == null){
                if(left.isUni){
                    if(root.val == left.uniVal) return new Stat(left.uniTreeCnt+1,left.uniVal,true);
                    else return new Stat(left.uniTreeCnt,left.uniVal,false);
                }else return new Stat(left.uniTreeCnt,left.uniVal,false);
            }else{
                if( left.isUni && right.isUni){
                    if(left.uniVal == right.uniVal && left.uniVal == root.val){
                        return new Stat(left.uniTreeCnt+right.uniTreeCnt+1,left.uniVal,true);
                    }else return new Stat(left.uniTreeCnt+right.uniTreeCnt,left.uniVal,false);
                }else{
                    return new Stat(left.uniTreeCnt+right.uniTreeCnt,left.uniVal,false);
                }
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
