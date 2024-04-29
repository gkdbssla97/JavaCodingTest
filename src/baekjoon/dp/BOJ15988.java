package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15988 {
    static final int MOD = 1_000_000_009;
    static int[] dp = new int[1_000_002];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution();
        for(int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            System.out.println(dp[v] % MOD);
        }
    }
    static void solution() {
        int[] board = {1, 2, 3};

        dp[0] = 1;
        for(int i = 0; i <= 1_000_000; i++) {
            for(int j = 0; j < 3; j++) {
                if (i - board[j] >= 0) {
                    dp[i] = dp[i] % MOD + dp[i - board[j]] % MOD;
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
    }
}
