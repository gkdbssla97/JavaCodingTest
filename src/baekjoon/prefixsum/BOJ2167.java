package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2167 {
    static int N, M;
    static int[][] board;
    static int[][] prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br. readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        board = new int[N][M];
        prefix = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(ss[j]);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefix[i][j] = board[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
//        for(int i = 1; i <= N; i++) {
//            System.out.println(Arrays.toString(prefix[i]));
//        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] a = br.readLine().split(" ");
            int x1 = Integer.parseInt(a[0]);
            int y1 = Integer.parseInt(a[1]);
            int x2 = Integer.parseInt(a[2]);
            int y2 = Integer.parseInt(a[3]);

            int val = prefix[x2][y2] - prefix[x2][y1 - 1] - prefix[x1 -1][y2] + prefix[x1 -1][y1 - 1];
            System.out.println(val);
        }
    }
}
