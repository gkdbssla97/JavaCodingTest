package baekjoon.divideandconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2630 {
    static int[][] board;
    static int white_cnt = 0, black_cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0, 0, n);
        System.out.println(white_cnt);
        System.out.println(black_cnt);
    }

    static void dfs(int x, int y, int len) {
        // 정사각형 검, 흰 전개 확인
        if(check(x, y, len)) {
            if(board[x][y] == 0) {
                white_cnt++;
            } else {
                black_cnt++;
            }
            return;
        }

        dfs(x, y, len / 2); // 좌측 상단
        dfs(x, y + len / 2, len / 2); // 우측 상단
        dfs(x + len / 2, y, len / 2); // 좌측 하단
        dfs(x + len / 2, y + len / 2, len / 2); // 우측 하단
    }

    static boolean check(int x, int y, int len) {
        int standard = board[x][y];
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (standard != board[i][j]) return false;
            }
        }
        return true;
    }
}
