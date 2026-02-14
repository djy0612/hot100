package main.java.easy;

public class hasCycle {
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

    public static boolean hasCycle(ListNode head){
        ListNode pre = head, next = head;
        while (next != null && next.next != null) {
            pre = pre.next;
            next = next.next.next;
            if (pre == next)
                return true;
        }
        return false;
    }
}
