//package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        for(int i = 0; i < n; i++){
            arr[i + 1] = Integer.parseInt(s[i]);
        }
        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }
        int max = -1001;
        for(int i = 1; i <=n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
//        System.out.println(Arrays.toString(dp));
    }
}
/**
 10, -4, 3, 1, 5, 6, -35, 12, 21, -1
 */
