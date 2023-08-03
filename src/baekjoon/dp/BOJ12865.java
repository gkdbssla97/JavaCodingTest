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
//            dp[w[i]] = Math.max(dp[w[i]], v[i]);
        }
        for (int i = 1; i <= n; i++) {
            for(int j = k; j - w[i] >= 0; j--) {
//                if(j + w[i] <= k) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
//                }
//                if(i == 1 && j == 2) System.out.println(v[i] + " " + dp[j]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        int asInt = Arrays.stream(dp).max().getAsInt();
        System.out.println(asInt);
    }
}
