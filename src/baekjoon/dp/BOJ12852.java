package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ12852 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] board = new int[n + 1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 3; j++) {
                if(j == 1) {
                    if(i % 3 == 0) {
//                        dp[i] = Math.min(dp[i] , dp[i / 3] + 1);
                        if(dp[i] > dp[i / 3] + 1) {
                            dp[i] = dp[i / 3] + 1;
                            board[i] = i / 3;
                        }
                    }
                }
                if (j == 2) {
                    if(i % 2 == 0) {
//                        dp[i] = Math.min(dp[i] , dp[i / 2] + 1);
                        if(dp[i] > dp[i / 2] + 1) {
                            dp[i] = dp[i / 2] + 1;
                            board[i] = i / 2;
                        }
                    }
                }
                if (j == 3) {
//                    dp[i] = Math.min(dp[i], dp[i - 1] + 1);
                    if(dp[i] > dp[i - 1] + 1) {
                        dp[i] = dp[i - 1] + 1;
                        board[i] = i - 1;
                    }
                }
            }
        }
        System.out.println(dp[n] - 1);
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n + " ");
            n = board[n];
        }
        System.out.println(sb.toString());
    }
}
// [0, 1, 2, 2, 3, 4, 3, 4, 4, 3, 4]