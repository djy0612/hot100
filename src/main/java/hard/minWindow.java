package main.java.hard;
import javax.crypto.interfaces.PBEKey;
import java.util.*;
public class minWindow {
    public static void main(String[] args) {
        String s = new String("ADOBECODEBANC");
        String p = new String("ABC");
        String ans = minWindow(s,p);
        System.out.println(ans);
    }

    public static String minWindow(String s, String t){
        int m = s.length();
        int n = t.length();
        String ans;
        int[] cnt = new int[128];
        int less=0;
        for(int i=0;i<n;i++){
            if(cnt[t.charAt(i)]==0){
                less++;
            }
            cnt[t.charAt(i)]++;
        }
        int left=0;
        int m_left = -1,m_right = m;
        for(int right=0;right<m;right++){
            cnt[s.charAt(right)]--;
            if(cnt[s.charAt(right)]==0)less--;
            while(less==0){
                if(right-left<m_right-m_left){
                    m_right = right;
                    m_left = left;
                }
                if(cnt[s.charAt(left)]==0) less++;
                cnt[s.charAt(left)]++;
                left++;
            }
        }
        if(m_left<0)return "";
        ans = s.substring(m_left,m_right+1);
        return ans;
    }
}
