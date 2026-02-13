package main.java.mid;

import java.util.Arrays;

public class productExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] ans = productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length];
        ans[0] =1;
        for(int i=1;i<nums.length;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        int suffix =1;
        for(int i=nums.length-2;i>=0;i--){
            suffix *= nums[i+1];
            ans[i] = ans[i]*suffix;
        }
        return  ans;
        //前后数组
        /*int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0) left[i] =1;
            else{
                left[i] = left[i-1]*nums[i-1];
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1) left[i] =1;
            else{
                right[i] = right[i+1]*nums[i+1];
            }
        }
        for(int i=0;i<nums.length;i++){
            ans[i] = left[i]*right[i];
        }
        return ans;*/
    }
}
