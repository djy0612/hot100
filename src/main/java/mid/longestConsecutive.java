package main.java.mid;

import java.util.*;

public class longestConsecutive {
    public static void main(String[] args){
        int[] nums = {100,4,200,1,3,2};
        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }
    public static int longestConsecutive(int[] nums){
        HashSet<Integer> numset = new HashSet<>();
        for (int num : nums) {
            numset.add(num);
        }
        int ans = 0;
        for (int num : numset) {
            if (numset.contains(num - 1))
                continue;
            else {
                int i = 1;
                while (numset.contains(++num)) {
                    i++;
                }
                ans = Math.max(ans, i);
            }

        }
        return ans;

    }
}
