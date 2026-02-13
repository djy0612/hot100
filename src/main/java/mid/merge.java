package main.java.mid;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = merge(intervals);
        System.out.println(Arrays.deepToString(ans));

    }
    public static int[][] merge(int[][] intervals){
        ArrayList<int[]> list = new ArrayList<int[]>();
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        for(int i=0;i<intervals.length;i++){
            if(list.isEmpty()||intervals[i][0]>list.get(list.size()-1)[1]){
                list.add(intervals[i]);
            }else if(intervals[i][0]<=list.get(list.size()-1)[1]){
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],intervals[i][1]);
            }

        }
        return list.toArray(new int[list.size()][]);
    }
}
