package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ2178 {
    static int w, h;
    static int[][] board;
    static int[][] visited;
    static Queue<Point> q;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + pos.x;
                int ny = dy[i] + pos.y;
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (visited[nx][ny] == 0 && board[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        board[nx][ny] = board[pos.x][pos.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        board = new int[h][w];
        visited = new int[h][w];

        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
            bfs(0, 0);
        System.out.println(board[h - 1][w - 1]);
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println();
//        }
    }
}
