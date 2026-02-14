package main.java.easy;

import java.util.List;

public class isPalindrome {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }
    public static boolean isPalindrome(ListNode head){
        ListNode pre = head,next = head;
        while(next!=null&&next.next!=null){
            pre = pre.next;
            next = next.next.next;
        }
        ListNode node = pre;
        ListNode cur = null;
        while(node!=null){
            ListNode tmp = node.next;
            node.next = cur;
            cur = node;
            node = tmp;
        }
        while(cur!=null){
            if(cur.val!=head.val)
                return false;
            cur = cur.next;
            head =  head.next;
        }
        return true;

    }
}
