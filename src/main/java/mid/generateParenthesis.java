package main.java.mid;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n){
        dfs(n,0,0);
        return ans;
    }
    public void dfs(int n,int left,int right){
        if(left==n&&right==n){
            ans.add(path.toString());
            return;
        }
        if(left<n){
            path.append('(');
            dfs(n,left+1,right);
            path.deleteCharAt(path.length()-1);
        }
        if(right<left){
            path.append(')');
            dfs(n,left,right+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
