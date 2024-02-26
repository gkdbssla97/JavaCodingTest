package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ10451 {
    static int[][] board;
    static int cnt;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            String[] s = br.readLine().split(" ");
            board = new int[n + 1][n + 1];
            for(int i = 0; i < n; i++) {
                board[i + 1][Integer.parseInt(s[i])] = 1;
            }
            cnt = 0;
            visited = new boolean[n + 1];
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(i, n);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
    static void dfs(int start, int n) {
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && board[start][i] == 1) {
                visited[i] = true;
                dfs(i, n);
            }
        }
    }
}