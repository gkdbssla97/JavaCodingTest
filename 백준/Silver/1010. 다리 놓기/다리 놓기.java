//package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            boolean[] visited = new boolean[b];

            int[][] dp = new int[31][31];

            // combination(0, a, b, visited);
            System.out.println(optimizeDpCombination(b, a, dp));
        }
    }

    static int optimizeDpCombination(int n, int r, int[][] dp) {
        if(dp[n][r] > 0) return dp[n][r];
        if(n == r || r == 0) return dp[n][r] = 1;
        return dp[n][r] = optimizeDpCombination(n - 1, r - 1, dp) + optimizeDpCombination(n - 1, r, dp);
    }
    static void combination(int start, int r, int n, boolean[] visited) {
        if(r == 0) {
            cnt++;
            return;
        }
        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(i + 1, r - 1, n, visited);
            visited[i] = false;
        }
    }
}
