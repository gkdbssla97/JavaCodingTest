package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }

        //누적합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] += board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int ans = board[r2][c2] - board[r2][c1 - 1] - board[r1 - 1][c2] + board[r1 - 1][c1 - 1];
            System.out.println(ans);
        }
    }
}
