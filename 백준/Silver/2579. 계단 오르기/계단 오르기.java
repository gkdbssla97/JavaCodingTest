//package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    static int[] stairs;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[301];
        stairs = new int[301];
        for(int i = 0; i < T; i++) {
            stairs[i + 1] = Integer.parseInt(br.readLine());
        }
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(dp[0] + stairs[2], dp[1]) + stairs[3];

        for(int i = 4; i <= T; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
        }

        System.out.println(dp[T]);
    }
}
