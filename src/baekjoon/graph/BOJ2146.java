package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BOJ2146 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int area = 1;
    static int curLandNum;
    static int res = Integer.MAX_VALUE;
    static class Point {
        int x, y;
        int cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int j = 0; j < collect.size(); j++) {
                board[i][j] = collect.get(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    markingLandNumber(i, j);
                    area++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] >= 1) {
                    visited = new boolean[N + 1][N + 1];
                    curLandNum = board[i][j];
                    bfs(i, j);

                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println(res);
    }

    static void markingLandNumber(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.x][p.y] = true;
            board[p.x][p.y] = area;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (board[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        board[nx][ny] = area;
                        q.offer(new Point(nx, ny, 0));
                    }
                }
            }
        }
    }
    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.x][p.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (board[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny, p.cnt + 1));
                    }
                    if (board[nx][ny] != 0 && board[nx][ny] != curLandNum && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        res = Math.min(res, p.cnt);
                    }
                }
            }
        }
    }
}
