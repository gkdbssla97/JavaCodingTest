package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1261 {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ;
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        board = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int ans = bfs();
        System.out.println(ans);
    }

    static int bfs() {

        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
        visited[0][0] = true;
        queue.offer(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.x == M - 1 && poll.y == N - 1) {
                return poll.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if (0 <= nx && nx < M && 0 <= ny && ny < N
                        && !visited[nx][ny]) {
                    if (board[nx][ny] == 1) {
                        queue.offer(new Point(nx, ny, poll.cnt + 1));
                        visited[nx][ny] = true;
                    } else {
                        queue.offer(new Point(nx, ny, poll.cnt));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return 0;
    }
}
