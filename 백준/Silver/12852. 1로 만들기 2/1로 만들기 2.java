// package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] tracking = new int[n + 1];
        tracking[n] = -1;
        Arrays.fill(dp, (int)1e9);
        dp[n] = 0;
        for (int i = n; i >= 1; i--) {
            if (i % 3 == 0) {
                if(dp[i / 3] > dp[i] + 1) {
                    dp[i / 3] = dp[i] + 1;
                    tracking[i / 3] = i;
                }
            }
            if (i % 2 == 0) {
                if(dp[i / 2] > dp[i] + 1) {
                    dp[i / 2] = dp[i] + 1;
                    tracking[i / 2] = i;
                }
            }
            if(dp[i - 1] > dp[i] + 1) {
                dp[i - 1] = dp[i] + 1;
                tracking[i - 1] = i;
            }
        }
        System.out.println(dp[1]);
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        while(cur != -1) {
            list.add(cur);
            cur = tracking[cur];
        }
        Collections.reverse(list);
//        System.out.println(list);
        IntStream.range(0, list.size()).forEach(i -> {
            System.out.print(list.get(i) + " ");
        });
    }
}
/**
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 */
