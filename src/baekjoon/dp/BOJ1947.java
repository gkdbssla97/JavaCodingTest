package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1947 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[] dp = new long[(int)n + 1];
        dp[1] = 0;
        dp[2] = 1;
        /**
         * dp[2] = 1
         * dp[3] = 2
         * dp[4] = 9
         * dp[5] = 44
         */
        for(int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % 1_000_000_000;
        }
        System.out.println(dp[(int)n]);
    }
}
