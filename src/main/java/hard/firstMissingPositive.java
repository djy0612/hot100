package main.java.hard;

public class firstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int ans = firstMissingPositive(nums);
        System.out.println(ans);
    }

    public static int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0)
                nums[i] = n+1;
        }

        for(int i=0;i<n;i++){
            if(Math.abs(nums[i])<n+1)
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0)
                return i+1;
        }
        return n+1;
    }
}
