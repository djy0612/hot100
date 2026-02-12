package main.java.hard;

import java.util.Arrays;
import java.util.LinkedList;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k =3;
        int[] ans = maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=0;i<nums.length;i++){

            if(!deque.isEmpty()&&deque.peekFirst()<=i-k){
                deque.removeFirst();
            }
            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i>=k-1)ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
