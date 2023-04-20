package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ2178 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        bfs(0, 0);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
        System.out.println(board[N - 1][M - 1]);
    }
    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while(!q.isEmpty()) {
            Point poll = q.poll();
            visited[poll.x][poll.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if(0 <= nx && nx < N && 0<= ny && ny < M
                    && !visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    board[nx][ny] = board[poll.x][poll.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    static class Point{
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
