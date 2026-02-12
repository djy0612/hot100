package main.java.mid;

import java.util.*;

public class threeSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] sp = line.split(",");
        int[] nums = new int[sp.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sp[i]);
        }
        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);

    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j=i+1,m=nums.length-1;
            while(j<m){
                int sum = nums[i]+nums[j]+nums[m];
                if(sum==0){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[m]));
                    j++;
                    m--;
                    while(j<m&&nums[m]==nums[m+1])m--;
                    while(j<m&&nums[j]==nums[j-1])j++;
                }else if(sum>0){
                    m--;
                }else{
                    j++;
                }
            }
        }
        return ans;
    }
}
