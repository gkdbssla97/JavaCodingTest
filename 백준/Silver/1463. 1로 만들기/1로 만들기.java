//package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int max = 1_000_000;
        int[] dp = new int[max + 1];
        dp[1] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 2; i <= t; i++) {
            dp[i] = Math.min(dp[i - 1] + 1,  Math.min(dp[i % 2 == 0 ? i / 2 : i - 1] + 1, dp[i % 3 == 0 ? i / 3 : i - 1] + 1));
        }
        System.out.println(dp[t]);
    }
}
/**
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 */
