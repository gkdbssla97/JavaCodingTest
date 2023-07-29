package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9465 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n + 1];

            for (int j = 0; j < 2; j++) {
                String[] s = br.readLine().split(" ");
                for (int k = 1; k <= s.length; k++) {
                    board[j][k] = Integer.parseInt(s[k - 1]);
                }
            }
            int[][] dp = new int[2][n + 1];
            dp[0][1] = board[0][1];
            dp[1][1] = board[1][1];

            for(int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + board[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + board[1][j];
//                max = Math.max(dp[0][j], dp[1][j]);
            }
//            System.out.println();
//            for(int x = 0; x < 2; x++) {
//                System.out.println(Arrays.toString(dp[x]));
//            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
