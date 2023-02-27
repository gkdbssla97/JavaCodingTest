package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16507 {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        board = new int[R + 1][C + 1];
        for (int j = 1; j <= R; j++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= C; k++) {
                board[j][k] = Integer.parseInt(st.nextToken());
            }
        }
        // 누적합 만들기
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
            }
        }
//        System.out.println();
//        for (int i = 1; i <= R; i++) {
//            for(int j = 1; j <= C; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int k = 0; k < Q; k++) {
            String[] s = br.readLine().split(" ");
            int r1 = Integer.parseInt(s[0]);
            int c1 = Integer.parseInt(s[1]);
            int r2 = Integer.parseInt(s[2]);
            int c2 = Integer.parseInt(s[3]);

            int res = board[r2][c2] - board[r2][c1 - 1] - board[r1 - 1][c2] + board[r1 - 1][c1 - 1];
            System.out.println(res / ((r2 - r1 + 1) * (c2- c1 + 1)));
        }
    }
}
