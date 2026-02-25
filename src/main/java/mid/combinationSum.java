package main.java.mid;

import com.sun.jndi.cosnaming.CNCtx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class combinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return ans;
    }
    public void dfs(int[] candidates, int target,int start){
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(sum<target){
            for(int i=start;i<candidates.length;i++){
                path.add(candidates[i]);
                sum+=candidates[i];
                dfs(candidates,target,i);
                path.remove(path.size()-1);
                sum-=candidates[i];
            }
        }
    }
}
