package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17086 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
    static int res_max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < ss.length; j++) {
                board[i][j] = Integer.parseInt(ss[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];
                if (board[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    int bfs = bfs(i, j);
                    if (res_max <= bfs) {
                        res_max = bfs;
                    }
                }
            }
        }
        System.out.println(res_max);
    }

    static int bfs(int x, int y) {
        int max = 0;
        int step = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();
            visited[poll.x][poll.y] = true;
            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if (0 <= nx && nx < N && 0 <= ny && ny < M
                        && !visited[nx][ny]) {
                    if (board[nx][ny] != 1) {
                        q.offer(new Point(nx, ny, poll.cost + 1));
                        visited[nx][ny] = true;
//                        System.out.println("nx, ny, max: " + nx + " " + ny + " " + max);
                    } else {
                        return poll.cost + 1;
                    }
                }
            }
        }
        return step;
    }

    static class Point {
        int x, y, cost;

        Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
