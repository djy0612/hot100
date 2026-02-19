package main.java.hard;

import main.java.mid.lowestCommonAncestor;

public class maxPathSum {
    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans,left+right+root.val);
        return Math.max(0,Math.max(left,right)+root.val);
    }
}
