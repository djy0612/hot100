package main.java.mid;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    List<String> ans = new ArrayList<>();
    StringBuilder  path = new StringBuilder ();
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        dfs(digits,0);
        return ans;

    }
    public void dfs(String digits,int start){
        if(start==digits.length()){
            ans.add(path.toString());
            return;
        }
        int idx = digits.charAt(start)-'0';
        for(int i=0;i<map[idx].length();i++){
            path.append(map[idx].charAt(i));
            dfs(digits,start+1);
            path.deleteCharAt(path.length()-1);
        }
    }

}
