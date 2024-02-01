package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            board[i + 1] = v;
        }
        dp[1] = board[1];
        if(n == 1) {System.out.println(board[1]); System.exit(0);}
        dp[2] = Math.max(dp[1], Math.max(board[1] + board[2], board[2] + board[0]));
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], board[i - 1] + dp[i - 3]) + board[i]);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
