package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        for(int i = 1; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(dp));
        System.out.println(n - max);
    }
}
