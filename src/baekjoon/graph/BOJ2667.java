package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ2667 {

    static int[][] board;
    static int[][] visited;
    static int N;
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int cnt;
    static List<Integer> house_c = new ArrayList<>();
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

        int house_count = 1;
        while (!q.isEmpty()) {
            Point pos = q.poll();
            visited[pos.x][pos.y] = 1;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + pos.x;
                int ny = dy[i] + pos.y;
//                System.out.println(nx + " " + ny);
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (board[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                        house_count++;
                    }
                }
            }
        }
        house_c.add(house_count);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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
        house_c.stream().sorted()
                .forEach(System.out::println);
    }
}
