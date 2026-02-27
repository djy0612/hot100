package main.java.mid;
import java.util.*;

public class partitionLabels {
    public List<Integer> partitionLabels(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int end = -1;
        int start = 0;
        for(int i=0;i<s.length();i++){
            end = Math.max(map.get(s.charAt(i)),end);
            if(i==end){
                ans.add(end-start+1);
                start = end+1;
            }
        }
        return ans;
    }
}
