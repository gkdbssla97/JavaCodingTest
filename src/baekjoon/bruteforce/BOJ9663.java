package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class BOJ9663 {
    static int n, cnt = 0;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dfs(0, n);
        System.out.println(cnt);
    }

    static void dfs(int col, int n) {
        if (col == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 가로
            if (isPossibleRow(i, col)) {
                // 사선
                if (isPossibleDiagonal(i, col)) {
                    board[i][col] = 1;
                    dfs(col + 1, n);
                    board[i][col] = 0;
                }

            }
        }
    }

    static boolean isPossibleRow(int x, int col) {
        for (int i = 0; i < col; i++) {
            if (board[x][i] != 0) return false;
        }
        return true;
    }

    static boolean isPossibleDiagonal(int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] != 0 && Math.abs(i - x) == Math.abs(j - y)) {
                    return false;
                }
            }
        }
        return true;
    }
}
