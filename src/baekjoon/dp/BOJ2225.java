package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[][] dp = new int[k + 1][n + 1];
        Arrays.fill(dp[1], 1);
        for(int i = 1; i <= k; i++) dp[i][0] = 1;
        for(int i = 1; i < k; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i + 1][j] = (dp[i + 1][j - 1] % 1_000_000_000)
                        + (dp[i][j] % 1_000_000_000);
            }
        }
//        for(int i = 0; i <= k; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[k][n] % 1_000_000_000);
    }
}
