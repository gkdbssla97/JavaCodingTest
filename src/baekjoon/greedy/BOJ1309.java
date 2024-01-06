package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][3];
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901; // 우리에 없음
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901; // 우리 왼쪽
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901; // 우리 오른쪽
        }
        System.out.println((Arrays.stream(dp[n]).sum()) % 9901);
    }
}
