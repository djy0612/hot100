package main.java.mid;

import java.util.*;

public class searchMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                matrix[i][j] = sc.nextInt();
        }
        int target = sc.nextInt();
        boolean flag = searchMatrix(matrix,target);
        System.out.println(flag);
    }

    public static boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int i=0,j=n-1;
        while(i<m&&j>=0){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]<target)
                i++;
            else
                j--;
        }
        return false;

    }
}
