package main.java.hard;

import main.java.mid.swapPairs;

import java.time.Year;

public class reverseKGroup {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {

    }
    public static ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prehead = dummy;
        while(head!=null){
            ListNode tail = prehead;
            for(int i=0;i<k;i++){
                tail = tail.next;
                if(tail==null) return dummy.next;
            }
            ListNode nheadG = tail.next;
            ListNode headG = prehead.next;
            tail.next = null;
            prehead.next = reverseGroup(headG);
            headG.next = nheadG;
            prehead = headG;
            head = nheadG;
        }
        return dummy.next;
    }
    public static ListNode reverseGroup(ListNode head){
        ListNode pre = null;
        ListNode node = head;
        while(node!=null){
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }

}
