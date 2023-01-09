package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ9095 {
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[n]);
        }
    }
}
