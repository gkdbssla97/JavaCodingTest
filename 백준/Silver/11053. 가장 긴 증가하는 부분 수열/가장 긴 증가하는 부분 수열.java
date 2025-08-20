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
        for(int i = 1; i <= s.length; i++){
            arr[i] = Integer.parseInt(s[i - 1]);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for(int i = 1; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(arr[j] > arr[i]){
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
/**
 6
 10 20 10 30 20 50
 */
