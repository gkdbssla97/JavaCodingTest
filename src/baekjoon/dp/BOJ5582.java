package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5582 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String m = br.readLine();

        int[][] ch = new int[m.length() + 1][n.length() + 1];

        int max = 0;
        for (int i = 1; i <= m.length(); i++) {
            for (int j = 1; j <= n.length(); j++) {
                if(m.charAt(i - 1) == n.charAt(j - 1)) {
                    ch[i][j] = ch[i - 1][j - 1] + 1;
                    max = Math.max(max,  ch[i][j]);
                }
            }
        }

//        for (int i = 0; i < n.length(); i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(max);
    }
}
