package main.java.mid;

import java.util.Arrays;
import java.util.Scanner;

public class setZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] flag = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0)
                    flag[i][j]=1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(flag[i][j]==1){
                    for(int x=0;x<m;x++){
                        matrix[x][j]=0;
                    }
                    for(int x=0;x<n;x++){
                        matrix[i][x]=0;
                    }
                }
            }
        }
    }
}
