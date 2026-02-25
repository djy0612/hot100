package main.java.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class isValid {
    public boolean isValid(String s){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> deque = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                deque.push(c);
            }else{
                if(deque.isEmpty()||deque.pop()!=map.get(c))
                    return false;
            }
        }
        return deque.isEmpty();
    }
}
