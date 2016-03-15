package com.martin.lc;


/**
 * Created by Martin on 3/14/16.
 */
public class HouseRobIII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int x) { val = x;}
    }

    public static class Estimation {
        int includeMe;
        int excludeMe;

        public Estimation (int x, int y) {
            this.includeMe = x;
            this.excludeMe = y;
        }

        public int maxInside(){
            return Math.max(includeMe,excludeMe);
        }
    }
    public int rob(TreeNode root) {
        if(root == null) return 0;
        return findMaxVal(root).maxInside();
    }

    public Estimation findMaxVal (TreeNode root) {
        if( root == null ) return new Estimation(0,0);
        if( root.left == null && root.right == null) return new Estimation(root.val,0);

        Estimation left = findMaxVal(root.left);
        Estimation right = findMaxVal(root.right);

        int maxIn = root.val + left.excludeMe + right.excludeMe;
        int maxEx = left.maxInside() + right.maxInside();

        return new Estimation(maxIn,maxEx);
    }
}
