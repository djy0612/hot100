package main.java.mid;

import java.util.HashMap;

public class pathSum {
    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {

    }
    int count = 0;
    HashMap<Long,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum){
        map.put(0L,1);
        preorder(root,targetSum,0);
        return count;
    }
    public void preorder(TreeNode root, int targetSum,long sum){
        if(root == null)return ;
        sum += root.val;
        count+=map.getOrDefault(sum-targetSum,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        preorder(root.left,targetSum,sum);
        preorder(root.right,targetSum,sum);
        map.put(sum,map.getOrDefault(sum,0)-1);

    }
}
