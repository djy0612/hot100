package main.java.mid;
import java.util.*;
public class maxArea {
    public static void main(String[] args){
        //int[] height = {1,8,6,2,5,4,8,3,7};
        Scanner sc = new Scanner(System.in);
        String len = sc.nextLine();
        String[] arg = len.split(",");
        int[] height = new int[arg.length];
        for(int i=0;i<arg.length;i++){
            height[i] = Integer.parseInt(arg[i]);
        }
        int ans = maxArea(height);
        System.out.println(ans);
    }

    public static int maxArea(int[] height){
        int i=0,j=height.length-1;
        int ans = 0;
        while(i<=j){
            if(height[i]<height[j]){
                ans = Math.max(ans,(j-i)*height[i]);
                i++;
            }else{
                ans = Math.max(ans,(j-i)*height[j]);
                j--;
            }
        }
        return ans;
    }
}
