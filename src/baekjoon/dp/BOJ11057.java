package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11057 {
    static final int MOD = 10_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] = dp[i][j] % MOD + dp[i - 1][k] % MOD;
                }
            }
        }
        for(int i = 0; i <=n ; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[n][0] % MOD);
    }
}
