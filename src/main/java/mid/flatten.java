package main.java.mid;

import java.util.Deque;
import java.util.LinkedList;

public class flatten {
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
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root){
        if(root==null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode pre = null;
        while(!stack.isEmpty()){
            root = stack.pop();
            if(pre!=null){
                pre.right = root;
                pre.left = null;
            }
            pre = root;
            if(root.right!=null)stack.push(root.right);
            if(root.left!=null)stack.push(root.left);
        }
    }
}
