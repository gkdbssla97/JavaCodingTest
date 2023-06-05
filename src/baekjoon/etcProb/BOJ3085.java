package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3085 {
    static int N;
    static String[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new String[N][N];

        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                board[i][j] = s[j];
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                change(i, j);
            }
        }

//        print();
        System.out.println(res);
    }

    private static void change(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (!board[nx][ny].equals(board[x][y])) {
                    // 교체
                    String val = board[nx][ny];
                    board[nx][ny] = board[x][y];
                    board[x][y] = val;

                    int row = check_row(board);
//                    System.out.println("row: " + row);
                    int col = check_col(board);
//                    System.out.println("col: " + col);
                    int tmp = Math.max(row, col);
                    if(tmp > res) {
                        res = tmp;
                    }
//                    System.out.println("->> " + res);
                    // 원복
                    val = board[nx][ny];
                    board[nx][ny] = board[x][y];
                    board[x][y] = val;
                }
            }
        }
    }
    private static int check_row(String[][] board) {
//        System.out.println("row-----");
//        print();
        // 행 검사
        int cnt = 1;
        int res = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(board[i][j].equals(board[i][j + 1])) {
                    cnt += 1;
                    if(res <= cnt) {
                        res = cnt;
                    }
                } else {
                    cnt = 1;
                }
            }
            cnt = 1;
        }
        return res;
    }

    private static int check_col(String[][] board) {
//        System.out.println("col-----");
//        print();
        // 열 검사
        int cnt = 1;
        int res = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(board[j][i].equals(board[j + 1][i])) {
                    cnt += 1;
//                    System.out.println("cnt: " + cnt);
//                    System.out.println("j, i: " + j + " " + i);
                    if(res <= cnt) {
                        res = cnt;
                    }
                } else {
                    cnt = 1;
                }
            }
            cnt = 1;
        }
        return res;
    }
    private static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
