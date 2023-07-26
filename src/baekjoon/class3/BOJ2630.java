package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2630 {
    static int N, white, blue;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        white = 0;
        blue = 0;

        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        find(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);

    }

    static void find(int size, int x, int y) {
        int kind = board[x][y];

        if(isUnion(size, x, y)) {
            if(kind == 1) {
                blue++;
            } else white++;
            return;
        }

        find(size / 2, x, y); // 1사분면
        find(size / 2, x, y + size / 2); // 2사분면
        find(size / 2, x + size / 2, y); // 3사분면
        find(size / 2, x + size / 2, y + size / 2); // 4사분면

    }

    static boolean isUnion(int size, int x, int y) {
        int color = board[x][y];
        for(int i = x; i < size + x; i++) {
            for(int j = y; j < size + y; j++) {
                if(color != board[i][j]) {
                    return false;
                }
            }
        } return true;
    }
}
