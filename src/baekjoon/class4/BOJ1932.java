package baekjoon.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
                dp[i][j] = board[i][j];
            }
        }
        dp[0][0] = board[0][0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if(j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + board[i][j];
                }
            }
        }
        int answer = Arrays.stream(dp[n - 1]).max().getAsInt();
//        for(int i = 0; i < n; i++)
//            System.out.println(Arrays.toString(dp[i]));
        System.out.println(answer);
    }
}
