package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ4963 {

    static int[][] board;
    static int[][] visited;
    static int w;
    static int h;
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int cnt = 0;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point pos = q.poll();
            visited[pos.x][pos.y] = 1;
            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + pos.x;
                int ny = dy[i] + pos.y;
//                System.out.println(nx + " " + ny);
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (board[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            board = new int[h][w];
            visited = new int[h][w];

            for (int i = 0; i < h; i++) {
                List<String> s = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
                for (int j = 0; j < s.size(); j++) {
                    board[i][j] = Integer.parseInt(s.get(j));
                }
            }

            cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] == 0 && board[i][j] == 1) {
                        bfs(i, j);
//                    System.out.println("i, j: " + i + " " + j);
                        cnt++;
                    }
                }
            }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(visited[i][j]);
//            }
//            System.out.println();
//        }

            System.out.println(cnt);
        }
    }
}
