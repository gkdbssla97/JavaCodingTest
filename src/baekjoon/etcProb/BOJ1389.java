package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1389 {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
            board[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) board[i][j] = 0;
                else if (board[i][j] > 0) {
                    continue;
                } else if (board[i][j] == 0) {
                    board[i][j] = 1000000;
                }
            }
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        int sum = 100000;
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            int array_sum = Arrays.stream(board[i]).sum();
            if (array_sum < sum) {
                sum = array_sum;
                idx = i;
            }
        }
        System.out.println(idx);
    }
}
