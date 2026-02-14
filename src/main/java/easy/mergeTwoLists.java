package main.java.easy;

import java.util.List;

public class mergeTwoLists {
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode head = new ListNode();
        ListNode prehead = head;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                head.next = list2;
                list2 = list2.next;
            }else{
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }
        head.next = list1!=null?list1:list2;
        return prehead.next;
    }

}
