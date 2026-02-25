package main.java.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class findKthLargest {
    public int findKthLargest(int[] nums, int k){
        List<Integer> input = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            input.add(nums[i]);
        }
        return quickSelect(input,k);
    }
    public int quickSelect(List<Integer> nums, int k){
        Random random = new Random();
        int pivot = random.nextInt(nums.size());
        List<Integer> small =  new ArrayList<>();
        List<Integer> equal =  new ArrayList<>();
        List<Integer> big =  new ArrayList<>();
        for(int x:nums){
            if(x<nums.get(pivot))
                small.add(x);
            else if(x>nums.get(pivot))
                big.add(x);
            else
                equal.add(x);
        }
        if(big.size()>=k)
            return quickSelect(big,k);
        else if(nums.size()-k<small.size())
            return quickSelect(small,small.size()-nums.size()+k);
        else
            return nums.get(pivot);
    }
}
