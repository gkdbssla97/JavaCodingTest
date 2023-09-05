package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BOJ12865_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[][] board = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            board[i + 1][0] = Integer.parseInt(s[0]);
            board[i + 1][1] = Integer.parseInt(s[1]);
        }
        int[][] dp = new int[n + 1][k + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                if(j - board[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - board[i][0]] + board[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int res = 0;
        for(int i = 0; i <= k; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }
}
