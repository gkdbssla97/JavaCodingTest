package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ7576 {
    static int w, h;
    static int[][] tomato;
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

    static void bfs() {
        while (!q.isEmpty()) {
            Point pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + pos.x;
                int ny = dy[i] + pos.y;
                if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                    if (visited[nx][ny] == 0 && tomato[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        tomato[nx][ny] = tomato[pos.x][pos.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomato = new int[h][w];
        visited = new int[h][w];

        for (int i = 0; i < h; i++) {
            List<Integer> tomatoes = Arrays.stream(br.readLine()
                            .split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int j = 0; j < tomatoes.size(); j++) {
                tomato[i][j] = tomatoes.get(j);
            }
        }
        if (Arrays.stream(tomato)
                .flatMapToInt(Arrays::stream)
                .allMatch(s -> s != 0)) {
            System.out.println(0);
            return;
        }
        q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] == 0 && tomato[i][j] == 1) {
                    visited[i][j] = 1;
                    q.offer(new Point(i, j));
                }
            }
        }
        bfs();
        if (Arrays.stream(tomato)
                .flatMapToInt(Arrays::stream)
                .anyMatch(s -> s == 0)) {
            System.out.println(-1);
        } else {
            System.out.println(Arrays.stream(tomato)
                    .flatMapToInt(Arrays::stream)
                    .max().getAsInt() - 1);
        }
    }
}
