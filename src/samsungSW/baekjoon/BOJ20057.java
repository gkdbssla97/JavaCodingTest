package samsungSW.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20057 {
    static int n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board;
    static int[][] tmp;
    static int res = 0;
    static int[][] dust_dx = {{-1, 1, -1, 1, -2, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 1, -1, 2, -2, 1, -1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] dust_dy = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -1, 1, -2, 2, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {1, -1, 1, -1, 2, -2, 1, -1, 0}};
    static int[] dust = {1, 1, 7, 7, 2, 2, 10, 10, 5};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        start(n / 2, n / 2);
//        print();
        System.out.println(res);
    }

    static void start(int x, int y) {

        int move = 1;
        int time = 0;
        int r_time = 0;
        boolean flag = false;
        while (true) {

            for (int i = 0; i < 4; i++) {
                for(int j = 0; j < move; j++) {
                    int nx = (dx[i] + x);
                    int ny = (dy[i] + y);
//                    x = nx;
//                    y = ny;
                    if(nx == 0 && ny == -1) {
                        flag = true;
                        break;
                    }
//                    System.out.println(nx + " " + ny);
                    int sum = 0;
                    for(int k = 0; k < 9; k++) {
                        int _nx = dust_dx[i][k] + nx;
                        int _ny = dust_dy[i][k] + ny;
                        if(isRange(_nx, _ny)) {
                            sum += (board[nx][ny] * dust[k] * 0.01);
                            board[_nx][_ny] += (board[nx][ny] * dust[k] * 0.01);
                        } else {
                            res += (board[nx][ny] * dust[k] * 0.01);
                            sum += (board[nx][ny] * dust[k] * 0.01);
                        }
                    }
                    int px = dx[i] + nx;
                    int py = dy[i] + ny;
                    if(isRange(px, py)) {
//                            System.out.println("sum: " + sum);
                        board[px][py] += board[nx][ny] - sum;
                    } else {
                        res += board[nx][ny] - sum;
                    }
                    x = nx;
                    y = ny;
                }
                if(flag) break;
                time++;
                if(time % 2 == 0 && time != 0) {
                    move++;
                    time = 0;
                    r_time++;
                }
            }
            if(flag) break;
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static void print() {
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
