package main.java.mid;

import java.util.*;

public class topKFrequent {
    // 小根堆
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minheap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            minheap.add(entry);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = minheap.poll().getKey();
        }
        return ans;
    }
    // 用数组替换掉map
    public int[] topKFrequent_1(int[] nums, int k){
        int offset = 10000;
        int[] freq = new int[20001];
        for(int num:nums){
            freq[num+offset]++;
        }
        PriorityQueue<int[]> minheap = new PriorityQueue<>(
               Comparator.comparingInt(a->a[1])
        );
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                minheap.add(new int[]{i-offset,freq[i]});
                if(minheap.size()>k){
                    minheap.poll();
                }
            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = minheap.poll()[0];
        }
        return ans;
    }
    
    // 手撕堆
    class Entry{
        int key;
        int val;
        Entry(int key,int val){
            this.key =  key;
            this.val = val;
        }
    }
    class minheap{
        Entry[] heap;
        int size;
        int capacity;
        minheap(int capacity){
            this.capacity = capacity;
            heap = new Entry[capacity];
        }
        public void add(Entry entry){
            if(size<capacity){
                heap[size] = entry;
                siftUp(size++);
            }else if(heap[0].val<entry.val)
            {
                heap[0] = entry;
                siftDown(0);
            }
        }
        Entry poll(){
            Entry min = heap[0];
            heap[0] = heap[--size];
            heap[size] = null;
            siftDown(0);
            return min;
        }
        void siftUp(int index){
            while(index>0){
                int parent = (index-1)/2;
                if(heap[parent].val<=heap[index].val) break;
                swap(index,parent);
                index = parent;
            }
        }
        void siftDown(int index){
            int left = 2*index+1;
            while(left<size){
                int minidx = left;
                int right = left+1;
                if(right<size&&heap[right].val<heap[left].val)
                    minidx = right;
                if (heap[index].val <= heap[minidx].val) break;
                swap(index,minidx);
                index = minidx;
                left = 2*index+1;
            }
        }
        void swap(int i,int j){
            Entry tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }
    public int[] topKFrequent_2(int[] nums, int k){
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        minheap heap = new minheap(k);
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            heap.add(new Entry(entry.getKey(),entry.getValue()));
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = heap.poll().key;
        }
        return ans;

    }
}
