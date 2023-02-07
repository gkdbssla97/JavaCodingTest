package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1992 {
    static int[][] board;
    static int N;
    static boolean totalCheck = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        checkSquare(0, 0, N);
    }

    static void checkSquare(int x, int y, int M) {
        //System.out.println("x, y, M: " + x + " " + y + " " + M);
        if(M == N) {
            for (int i = x; i < x + M; i++) {
                for (int j = y; j < y + M; j++) {
                    if (board[i][j] != board[x][y]) {
                        totalCheck = true;
                        break;
                    }
                }
                if (totalCheck)
                    break;
            }
            if (!totalCheck) {
                System.out.println(board[x][y]);
                return;
            }
            else System.out.print("(");
        }
        //왼쪽위
        boolean flag = false;
        for (int i = x; i < x + M / 2; i++) {
            for (int j = y; j < y + M / 2; j++) {
                if (board[i][j] != board[x][y]) {
                    flag = true;
                    System.out.print("(");
                    checkSquare(x, y, M / 2);
                    break;
                }
            }
            if (flag)
                break;
        }
        if (!flag) {
            System.out.print(board[x][y]);
        }

        //오른쪽위
        flag = false;
        for (int i = x; i < x + M / 2; i++) {
            for (int j = y + M / 2; j < y + M; j++) {
                if (board[i][j] != board[x][y + M / 2]) {
                    flag = true;
                    System.out.print("(");
                    checkSquare(x, y + M / 2, M / 2);
                    break;
                }
            }
            if (flag)
                break;
        }
        if (!flag) {
            System.out.print(board[x][y + M / 2]);
        }

        //왼쪽 아래
        flag = false;
        for (int i = x + M / 2; i < x + M; i++) {
            for (int j = y; j < y + M / 2; j++) {
                if (board[i][j] != board[x + M / 2][y]) {
                    flag = true;
                    System.out.print("(");
                    checkSquare(x + M / 2, y, M / 2);
                    break;
                }
            }
            if (flag)
                break;
        }
        if (!flag) {
            System.out.print(board[x + M / 2][y]);
        }

        //오른쪽 아래
        flag = false;
        for (int i = x + M / 2; i < x + M; i++) {
            for (int j = y + M / 2; j < y + M; j++) {
                if (board[i][j] != board[x + M / 2][y + M / 2]) {
                    flag = true;
                    System.out.print("(");
                    checkSquare(x + M / 2, y + M / 2, M / 2);
                    break;
                }
            }
            if (flag)
                break;
        }
        if (!flag) {
            System.out.print(board[x + M / 2][y + M / 2]);
        }
        System.out.print(")");
    }
}
