package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[][] board = new int[n + 1][2];
        int[] dp = new int[k + 1];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int w = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);

            board[i + 1][0] = w;
            board[i + 1][1] = v;
        }

        for(int i = 0; i <= n; i++) {
            for(int j = k; j >= 0; j--) {
                if(j - board[i][0] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - board[i][0]] + board[i][1]);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[k]);
    }
}
