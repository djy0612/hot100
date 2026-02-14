package main.java.easy;

import java.util.List;

public class detectCycle {
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
    public static ListNode detectCycle(ListNode head){
        if(head==null||head.next==null)return null;
        ListNode pre = head, next = head;
        while (next != null && next.next != null) {
            pre = pre.next;
            next = next.next.next;
            if (pre == next)
                break;
        }
        if(pre!=next)return null;
        pre = head;
        while(pre!=next){
            pre = pre.next;
            next = next.next;
        }
        return pre;

    }

}
