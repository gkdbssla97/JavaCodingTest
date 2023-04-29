package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1780 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int cnt_zero, cnt_one, cnt_minus;
    static int res_cnt_zero, res_cnt_one, res_cnt_minus;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        res_cnt_zero = res_cnt_one = res_cnt_minus = 0;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    cnt_zero = cnt_one = cnt_minus = 0;
                    if(board[i][j] == 0) {
                        cnt_zero++;
                    } else if (board[i][j] == 1) {
                        cnt_one++;
                    } else cnt_minus++;
                    bfs(i, j, board[i][j]);
                }
            }
        }
        System.out.println(res_cnt_minus);
        System.out.println(res_cnt_zero);
        System.out.println(res_cnt_one);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
    }

    static void bfs(int x, int y, int marking) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point poll = q.poll();
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if (0 <= nx && nx < N && 0 <= ny && ny < N
                        && !visited[nx][ny] && board[nx][ny] == marking) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    if (marking == 0) {
                        cnt_zero++;
                    } else if (marking == 1) {
                        cnt_one++;
                    } else {
                        cnt_minus++;
//                        System.out.println("i,j: " + nx + " " + ny);
                    }
                }
                if (cnt_zero == 9) {
                    res_cnt_zero++;
                    return;
                } else if(cnt_minus == 9){
                    res_cnt_minus++;
                    return;
                } else if(cnt_one == 9) {
                    res_cnt_one++;
                    return;
                }
            }
        }
        res_cnt_one += cnt_one;
        res_cnt_minus += cnt_minus;
        res_cnt_zero += cnt_zero;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
