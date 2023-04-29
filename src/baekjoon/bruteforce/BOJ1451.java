package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1451 {
    static int N, M;
    static int[][] board;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        sum = 0;
        for (int i = 1; i < N; i++) {
            long a = getRectangleSum(0, i, 0, M);
            for (int j = 1; j < M; j++) {
                long b = getRectangleSum(i, N, 0, j);
                long c = getRectangleSum(i, N, j, M);

                long tmp = a * b * c;
                sum = Math.max(sum, tmp);
            }
            for (int j = i + 1; j < N; j++) {
                long b = getRectangleSum(i, j, 0, M);
                long c = getRectangleSum(j, N, 0, M);

                long tmp = a * b * c;
                sum = Math.max(sum, tmp);
            }
        }

        for (int i = N - 1; i > 0; i--) {
            long a = getRectangleSum(i, N, 0, M);

            for (int j = 1; j < M; j++) {
                long b = getRectangleSum(0, i, 0, j);
                long c = getRectangleSum(0, i, j, M);

                long tmp = a * b * c;
                sum = Math.max(sum, tmp);
            }
        }

        for (int i = 1; i < M; i++) {
            long a = getRectangleSum(0, N, 0, i);

            for (int j = 1; j < N; j++) {
                long b = getRectangleSum(0, j, i, M);
                long c = getRectangleSum(j, N, i, M);

                long tmp = a * b * c;
                sum = Math.max(sum, tmp);
            }

            for (int j = i + 1; j < M; j++) {
                long b = getRectangleSum(0, N, i, j);
                long c = getRectangleSum(0, N, j, M);

                long tmp = a * b * c;
                sum = Math.max(sum, tmp);
            }
        }

        for (int i = M - 1; i > 0; i--) {
            long a = getRectangleSum(0, N, i, M);

            for (int j = 1; j < N; j++) {
                long b = getRectangleSum(0, j, 0, i);
                long c = getRectangleSum(j, N, 0, i);

                long tmp = a * b * c;
                sum = Math.max(sum, tmp);
            }
        }
        System.out.println(sum);
    }

    public static long getRectangleSum(int sx, int ex, int sy, int ey) {
        long sum = 0;
        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }
}
