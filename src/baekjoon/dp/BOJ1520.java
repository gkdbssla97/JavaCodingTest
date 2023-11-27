package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1520 {
    static int[][] board, dp;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        board = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            Arrays.fill(dp[i], -1);
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
//        visited[0][0] = true;
//        dp[0][0] = 0;
        System.out.println(dfs(0, 0));
//        for(int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

    static int dfs(int x, int y) {
        if(x == n - 1 && y == m - 1) {
            return dp[n - 1][m - 1] = 1;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(isRange(nx, ny) && !visited[nx][ny]) {
                if(board[nx][ny] < board[x][y]) {
//                    visited[nx][ny] = true;
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}