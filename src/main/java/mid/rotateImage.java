package main.java.mid;

import java.util.Arrays;

public class rotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(matrix));
        rotateImage(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotateImage(int[][] matrix){
        int n =matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int tmp= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
    }
    public static void reverse(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;right--;
        }
    }
}
