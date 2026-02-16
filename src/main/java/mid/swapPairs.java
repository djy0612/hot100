package main.java.mid;

public class swapPairs {
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

    public static ListNode swapPairs(ListNode head){
        if(head==null)return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next!=null&&pre.next.next!=null){
            ListNode node = pre.next;
            ListNode next = node.next;
            ListNode tmp = next.next;
            pre.next = next;
            next.next = node;
            node.next = tmp;
            pre = node;
        }
        return dummy.next;
    }
}
