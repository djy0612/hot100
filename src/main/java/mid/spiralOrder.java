package main.java.mid;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public static void main(String[] args) {

    }
    public static List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int left=0,right=n-1,up = 0,down=m-1;
        int count=0;
        List<Integer> ans = new ArrayList<Integer>();
        while(ans.size()<m*n){
            for(int i=left;i<=right;i++){
                if(ans.size()<m*n)
                    return ans;
                ans.add(matrix[up][i]);
            }
            up--;
            for(int i=up;i<=down;i++){
                if(ans.size()<m*n)
                    return ans;
                ans.add(matrix[i][right]);
            }
            right--;
            for(int i=right;i>=left;i--){
                if(ans.size()<m*n)
                    return ans;
                ans.add(matrix[down][i]);
            }
            down++;
            for(int i=down;i>=up;i++){
                if(ans.size()<m*n)
                    return ans;
                ans.add(matrix[i][left]);
            }
            left++;

        }
        return ans;
    }
}
