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
        int[] dp = new int[k + 1];
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] ss = br.readLine().split(" ");
            w[i] = Integer.parseInt(ss[0]);
            v[i] = Integer.parseInt(ss[1]);
        }
        for(int i = 1; i <= n; i++) {
            for(int j = k; j >= 0; j--) {
                if(j - w[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i <= k; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
