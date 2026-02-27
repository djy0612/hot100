package main.java.mid;



import java.util.HashMap;
import java.util.List;

public class LRUCache {
    public static class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode pre;
        ListNode(){}
        ListNode(int x,int y){
            key = x;
            val = y;
            next = null;
            pre = null;
        }
    }
    int lru_capacity;
    int size;
    HashMap<Integer,ListNode> map;
    ListNode head,end;
    public LRUCache(int capacity) {
        lru_capacity = capacity;
        size = 0;
        map = new HashMap<>();
        //初始化链表
        head = new ListNode();
        end = new ListNode();
        head.next = end;
        end.pre = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if(node==null)
            return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode tmp = map.get(key);
            tmp.val = value;
            moveToHead(tmp);
        }else{
            ListNode node = new ListNode(key,value);
            map.put(key,node);
            addToHead(node);
            size++;
        }
        if(size>lru_capacity){
            map.remove(end.pre.key);
            removeNode(end.pre);
            size--;
        }
    }

    // 删除节点
    public void removeNode(ListNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    // 移动节点至链表头部
    public void moveToHead(ListNode node){
        removeNode(node);
        addToHead(node);
    }
    //向链表头部插入新节点
    public void addToHead(ListNode node){
        ListNode tmp = head.next;
        head.next = node;
        node.next = tmp;
        tmp.pre = node;
        node.pre = head;
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // 输出 1
        lruCache.put(3, 3); // 删除键 2
        System.out.println(lruCache.get(2)); // 输出 -1
    }
}
