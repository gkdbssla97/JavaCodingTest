package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14503 {
    static int N, M, r, c, d;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 북동남서 0 1 2 3
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        board = new int[N][M];
        visited = new boolean[N][M];

        String[] ss = br.readLine().split(" ");
        r = Integer.parseInt(ss[0]);
        c = Integer.parseInt(ss[1]);
        d = Integer.parseInt(ss[2]);

        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < a.length; j++) {
                board[i][j] = Integer.parseInt(a[j]);
            }
        }
//        print();
        bfs(r, c, d);
        int res = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static void bfs(int r, int c, int d) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c));
        visited[r][c] = true;
        int tmp = d;
        while(!q.isEmpty()) {
            boolean flag = false;
            Point p = q.poll();
            visited[p.x][p.y] = true;
            for(int i = 0; i < 4; i++) {
                d -= 1;
                if(d < 0) {
                    d = 4 + d;
                }
                int nx = dx[d] + p.x;
                int ny = dy[d] + p.y;

                if(0 <= nx && nx < N && 0 <= ny && ny < M &&
                board[nx][ny] == 0 && !visited[nx][ny]) {
                    flag = true;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    break;
                }
            }
            // 빈칸 X
            if(!flag) {
               if(d == 0) {
                   tmp = 2;
               } else if(d == 1) {
                   tmp = 3;
               } else if(d == 2) {
                   tmp = 0;
                } else {
                   tmp = 1;
               }
               int nx = dx[tmp] + p.x;
               int ny = dy[tmp] + p.y;
               if(board[nx][ny] == 0) {
                   q.offer(new Point(nx, ny));
                   visited[nx][ny] = true;
               } else {
                   break;
               }
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(Arrays.toString(board[i]) + " ");
            System.out.println();
        }
    }

}
