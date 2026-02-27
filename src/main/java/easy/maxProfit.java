package main.java.easy;

import java.util.Scanner;

public class maxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String len = sc.nextLine();
        String[] split = len.split(",");
        int[] prices = new int[split.length];
        for(int i=0;i<prices.length;i++)
            prices[i] = Integer.parseInt(split[i]);
        int ans = maxProfit(prices);
        System.out.printf(String.valueOf(ans));
    }
    public static int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min)
                min = prices[i];
            ans = Math.max(ans,prices[i]-min);

        }
        return ans;
    }
}
