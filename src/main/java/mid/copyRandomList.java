package main.java.mid;

import main.java.hard.reverseKGroup;

import java.util.HashMap;

public class copyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node tmp = head;
        while(tmp!=null){
            map.put(tmp,new Node(tmp.val));
            tmp = tmp.next;
        }
        tmp = head;
        while(tmp!=null){
            map.get(tmp).random = map.get(tmp.random);
            map.get(tmp).next = map.get(tmp.next);
            tmp = tmp.next;
        }
        return map.get(head);
    }
}
