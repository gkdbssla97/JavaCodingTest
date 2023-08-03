package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BOJ2293 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] coin = new int[n];
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k + 1]; //dp는 총금액
        dp[0] = 1;
        for(int c : coin) {
            for (int i = 1; i <= k; i++) {
                if(i - c >= 0) {
                    dp[i] += dp[i - c];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
