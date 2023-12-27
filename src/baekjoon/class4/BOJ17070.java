package baekjoon.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17070 {
    static int n;
    static int[][] board;
    static int[][][] dp;
    static boolean[][] visited;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n][3];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        visited[0][0] = true;
        dfs(new Node(0, 1, 0));
//        print();
        System.out.println(dp[0][1][0]);
    }

    static int dfs(Node node) {
        int x = node.x;
        int y = node.y;
        if (x == n - 1 && y == n - 1) {
            return dp[x][y][node.type] = 1;
        }

        if (dp[x][y][node.type] != 0) {
            return dp[x][y][node.type];
        }

        visited[x][y] = true;


        for (int i = 0; i < 3; i++) {
            if ((node.type == 0 && i == 1) || (node.type == 1 && i == 0)) continue;
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (isRange(nx, ny)) {
                if (i == 2 && (board[x][y + 1] == 1 || board[x + 1][y] == 1)) continue;
                dp[x][y][node.type] += dfs(new Node(nx, ny, i));
            }
        }
        return dp[x][y][node.type];
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n && board[x][y] == 0;
    }

    static class Node {
        int x, y, type;

        public Node(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type; // 0: 가로 1: 세로  2: 사선
        }
    }
}
