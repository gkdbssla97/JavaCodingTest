package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n + 1];
        int[] dp = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(board[j] < board[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).map(e -> e).max().getAsInt());

    }
}
