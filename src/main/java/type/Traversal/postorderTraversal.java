package main.java.type.Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class postorderTraversal {
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 递归
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postorder(list,root);
        return list;
    }
    public static void postorder(List<Integer> list, TreeNode root){
        if(root==null)
            return;
        postorder(list,root.left);
        postorder(list,root.right);
        list.add(root.val);
    }
    // 迭代
    public static List<Integer> postorderTraversal_1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack_1 = new ArrayDeque<>();
        Deque<TreeNode> stack_2 = new ArrayDeque<>();
        if(root==null)
            return list;
        stack_1.push(root);
        while(!stack_1.isEmpty()){
            root = stack_1.pop();
            stack_2.push(root);
            if(root.left!=null)
                stack_1.push(root.left);
            if(root.right!=null)
                stack_1.push(root.right);
        }
        while(!stack_2.isEmpty()){
            list.add(stack_2.pop().val);
        }
        return list;
    }
}
