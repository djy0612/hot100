package main.java.easy;
import java.security.spec.EncodedKeySpec;
import java.util.*;
public class reverseList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode node = reverseList(head);
        System.out.println(node.val);
    }

    public static ListNode reverseList(ListNode head){
        ListNode node = head;
        ListNode pre = null;
        while(node!=null){
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;

    }
}
