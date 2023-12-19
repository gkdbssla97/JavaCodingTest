package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ14500 {
    static int n, m, max = 0;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        test1();
        test2();
        test3();
        test4();
        test5();
        System.out.println(max);
    }

    static void test1() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m - 4; j++) {
                int sum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i][j + 3];
                max = Math.max(max, sum);
            }
        }

        for (int i = 0; i <= n - 4; i++) {
            for (int j = 0; j < m; j++) {
                int sum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 3][j];
                max = Math.max(max, sum);
            }
        }
    }

    static void test2() {
        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1];
                max = Math.max(max, sum);
            }
        }
    }

    static void test3() {
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 2][j + 1];
                max = Math.max(max, sum);
                int sum2 = board[i][j] + board[i][j + 1] + board[i + 1][j] + board[i + 2][j];
                max = Math.max(max, sum2);

                int sum3 = board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j] + board[i + 2][j + 1];
                max = Math.max(max, sum3);
                int sum4 = board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1];
                max = Math.max(max, sum4);
            }
        }

        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= m - 3; j++) {
                int sum = board[i + 1][j] + board[i][j] + board[i][j + 1] + board[i][j + 2];
                max = Math.max(max, sum);
                int sum2 = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 2];
                max = Math.max(max, sum2);

                int sum3 = board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2] + board[i][j + 2];
                max = Math.max(max, sum3);
                int sum4 = board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2];
                max = Math.max(max, sum4);
            }
        }
    }

    static void test4() {
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 2; j++) {
                int sum3 = board[i + 1][j] + board[i + 1][j + 1] + board[i][j] + board[i + 2][j + 1];
                max = Math.max(max, sum3);
                int sum4 = board[i][j + 1] + board[i + 1][j + 1] + board[i + 1][j] + board[i + 2][j];
                max = Math.max(max, sum4);
            }
        }

        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= m - 3; j++) {
                int sum = board[i][j + 2] + board[i + 1][j] + board[i + 1][j + 1] + board[i][j + 1];
                max = Math.max(max, sum);
                int sum2 = board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 1][j + 2];
                max = Math.max(max, sum2);
            }
        }
    }

    static void test5() {
        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= m - 3; j++) {
                int sum = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 1];
                max = Math.max(max, sum);
                int sum2 = board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2];
                max = Math.max(max, sum2);
            }
        }

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 2; j++) {
                int sum = board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 1][j + 1];
                max = Math.max(max, sum);
                int sum2 = board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1] + board[i + 1][j];
                max = Math.max(max, sum2);
            }
        }
    }
}
