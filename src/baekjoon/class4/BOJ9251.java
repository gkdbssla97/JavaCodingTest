package baekjoon.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9251 {
    static String A, B;
    static int lenA, lenB;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        lenA = A.length();
        lenB = B.length();
        A = "#" + A;
        B = "#" + B;

        dp = new int[lenA + 1][lenB + 1];
        init();

        for(int i = 2; i <= lenA; i++) {
            for(int j = 2; j <= lenB; j++) {
                if(A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[lenA][lenB]);
    }
    static void init() {
        dp[1][1] = (A.charAt(1) == B.charAt(1)) ? 1 : 0;

        for(int i = 2; i <= lenA; i++) {
            if(A.charAt(i) == B.charAt(1)) {
                dp[i][1] = 1;
            } else {
                dp[i][1] = dp[i - 1][1];
            }
        }

        for(int j = 2; j <= lenB; j++) {
            if(A.charAt(1) == B.charAt(j)) {
                dp[1][j] = 1;
            } else {
                dp[1][j] = dp[1][j - 1];
            }
        }
    }
}
