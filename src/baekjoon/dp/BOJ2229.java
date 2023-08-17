package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2229 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] dp = new int[n];
        //dp[i] = 인덱스 i까지 조가 잘 짜여진 정도의 최댓값

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(arr[i], Integer.MIN_VALUE);
            min = Math.min(arr[i], Integer.MAX_VALUE);
            for(int j = i; j >=0; j--) {
                max = Math.max(arr[j], max);
                min = Math.min(arr[j], min);
                if(j != 0)
                    dp[i] = Math.max(dp[i], dp[j - 1] + max - min);
                else dp[i] = Math.max(dp[i], max - min);
            }
        }
        System.out.println(dp[n - 1]);
//        System.out.println(Arrays.toString(dp));
    }
}
