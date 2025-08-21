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
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if(i + arr[i][0] <= n) {
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], arr[i][1] + dp[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
/**
 * 7
 * 3 10
 * 5 20
 * 1 10
 * 1 20
 * 2 15
 * 4 40
 * 2 200
 */
