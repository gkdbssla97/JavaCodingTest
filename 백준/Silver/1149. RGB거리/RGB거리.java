//package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] color = new int[t][3];
        for (int i = 0; i < t; i++) {
            String[] str = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int g = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            color[i][0] = r;
            color[i][1] = g;
            color[i][2] = b;
        }
        int[][] dp = new int[t + 1][3];
        dp[1][0] = color[0][0];
        dp[1][1] = color[0][1];
        dp[1][2] = color[0][2];
        for (int i = 1; i <= t; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]) + color[i - 1][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1]) + color[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j - 2]) + color[i - 1][j];
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(Arrays.stream(dp[t]).min().getAsInt());
    }
}
/**
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 */
