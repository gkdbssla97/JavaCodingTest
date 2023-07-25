package samsungSW.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//230725 22:21 ~ 23:16
public class BOJ14499 {
    static int N, M, x, y, K;
    static int[][] board;
    static int[] dice = new int[6];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        x = Integer.parseInt(s[2]);
        y = Integer.parseInt(s[3]);
        K = Integer.parseInt(s[4]);

        board = new int[N][M];
        int row = 0;
        for (int t = 0; t < N; t++) {
            String[] ss = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                board[row][j] = Integer.parseInt(ss[j]);
            }
            row++;

        }
//        for(int i = 0; i < board.length; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
        String [] _s = br.readLine().split(" ");
        for (int i = 0; i < _s.length; i++) {
            int cmd = Integer.parseInt(_s[i]);
            if (cmd == 1) {
                // 위치 이동
                int nx = dx[1] + x;
                int ny = dy[1] + y;
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    x = nx;
                    y = ny;
                    // 동
                    int tmp = dice[1];
                    dice[1] = dice[3];
                    dice[3] = dice[0];
                    dice[0] = dice[5];
                    dice[5] = tmp;

                    // 지도가 0이 아님
                    if(board[x][y] != 0) {
                        dice[5] = board[x][y];
                        board[x][y] = 0;
                    }
                    // 지도가 0임
                    else {
                        board[x][y] = dice[5];
                    }
                    System.out.println(dice[3]);
                }
            } else if (cmd == 2) {
                // 위치 이동
                int nx = dx[3] + x;
                int ny = dy[3] + y;
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    x = nx;
                    y = ny;
                    // 서
                    int tmp = dice[0];
                    dice[0] = dice[3];
                    dice[3] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = tmp;

                    // 지도가 0이 아님
                    if(board[x][y] != 0) {
                        dice[5] = board[x][y];
                        board[x][y] = 0;
                    }
                    // 지도가 0임
                    else {
                        board[x][y] = dice[5];
                    }
                    System.out.println(dice[3]);
                }
            } else if (cmd == 3) {
                // 위치 이동
                int nx = dx[0] + x;
                int ny = dy[0] + y;
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    x = nx;
                    y = ny;
                    // 북
                    int tmp = dice[2];
                    dice[2] = dice[3];
                    dice[3] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = tmp;

                    // 지도가 0이 아님
                    if(board[x][y] != 0) {
                        dice[5] = board[x][y];
                        board[x][y] = 0;
                    }
                    // 지도가 0임
                    else {
                        board[x][y] = dice[5];
                    }
                    System.out.println(dice[3]);
                }
            } else if (cmd == 4) {
                // 위치 이동
                int nx = dx[2] + x;
                int ny = dy[2] + y;
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    x = nx;
                    y = ny;
                    // 남
                    int tmp = dice[5];
                    dice[5] = dice[4];
                    dice[4] = dice[3];
                    dice[3] = dice[2];
                    dice[2] = tmp;

                    // 지도가 0이 아님
                    if(board[x][y] != 0) {
                        dice[5] = board[x][y];
                        board[x][y] = 0;
                    }
                    // 지도가 0임
                    else {
                        board[x][y] = dice[5];
                    }
                    System.out.println(dice[3]);
                }
            }
//            System.out.println("cmd: " + cmd);
//            System.out.println("dice" + Arrays.toString(dice));
        }

    }
}
