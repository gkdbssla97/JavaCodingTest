package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9095 {
    static int[] dp = new int[11];
    static int[] ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ans = new int[T];
        int max = 0;
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            ans[i] = n;
            if(max < n) {
                max = n;
            }
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for(int i = 0; i < T; i++) {
            System.out.println(dp[ans[i]]);
        }
    }
}
