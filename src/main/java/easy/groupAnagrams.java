package main.java.easy;

import java.util.*;
public class groupAnagrams {
    public static void main(String[] args) {
        //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"} ;
        Scanner sc = new Scanner(System.in);
        String len = sc.nextLine();
        String[] strs = len.split(" ");
        System.out.println(groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> v = map.getOrDefault(key,new ArrayList<>());
            v.add(str);
            map.put(key,v);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
