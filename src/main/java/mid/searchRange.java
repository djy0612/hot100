package main.java.mid;

import com.sun.org.apache.bcel.internal.generic.FALOAD;
import org.omg.CORBA.IRObject;

public class searchRange {
    public int[] searchRange(int[] nums, int target){
        int n = nums.length;
        int[] ans = {-1,-1};
        int left = 0,right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<target){
                left++;
            }else{
                right--;
            }
        }
        if(left>=n||nums[left]!=target) return ans;
        ans[0] = left;
        right=n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]<=target){
                left++;
            }else{
                right--;
            }
        }
        ans[1] = right;
        return ans;
    }
}
