//package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int div = 10_007;
        int[] dp  = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= t; i++) {
            dp[i] = dp[i - 1] % div + dp[i - 2] % div;
        }
        System.out.println(dp[t] % div);
    }
}
/**
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 */
