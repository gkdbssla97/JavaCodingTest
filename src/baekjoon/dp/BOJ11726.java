package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    static int[] dp = new int[1001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        for(int i = 5; i <= n; i++) {
            dp[i] = ((dp[i - 1] % 10007) + (dp[i - 2] % 10007)) % 10007;
        }
        System.out.println(dp[n]);
    }
}