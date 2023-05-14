package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16507 {
    static int[][] board;
    static int[][] prefix_sum;
    static int R, C, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        Q = Integer.parseInt(s[2]);

        board = new int[R][C];
        prefix_sum = new int[R + 1][C + 1];
        for (int i = 0; i < R; i++) {
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < ss.length; j++) {
                board[i][j] = Integer.parseInt(ss[j]);
            }
        }
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                prefix_sum[i][j] = board[i - 1][j - 1] + prefix_sum[i - 1][j] + prefix_sum[i][j - 1] - prefix_sum[i - 1][j - 1];
            }
        }
        for (int k = 0; k < Q; k++) {
            String[] z = br.readLine().split(" ");
            int x1 = Integer.parseInt(z[0]);
            int y1 = Integer.parseInt(z[1]);
            int x2 = Integer.parseInt(z[2]);
            int y2 = Integer.parseInt(z[3]);
            int cnt = (x2 - x1 + 1) * (y2 - y1 + 1);
            int val = prefix_sum[x2][y2] - prefix_sum[x2][y1 - 1] - prefix_sum[x1 - 1][y2] + prefix_sum[x1 - 1][y1 - 1];
//            System.out.println(val);
            System.out.println(val / cnt);
        }
    }
}
