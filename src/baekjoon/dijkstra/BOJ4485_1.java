package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485_1 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }
            board = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for(int j = 0; j < s.length; j++) {
                    board[i][j] = Integer.parseInt(s[j]);
                }
            }

            System.out.println(String.format("Problem %d: %d", idx++, bfs(0, 0)));
        }
    }
    static int bfs(int x, int y) {
        int res = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Point(x, y, board[x][y]));
        visited[x][y] = true;

        while(!pq.isEmpty()) {
            Point poll = pq.poll();
            visited[poll.x][poll.y] = true;

            if(poll.x == N - 1 && poll.y == N - 1) {
                res = poll.cost;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if(0 <= nx && nx < N && 0 <= ny && ny < N &&
                !visited[nx][ny]) {
                    visited[nx][ny] = true;
//                    System.out.println(nx + " " + ny + " " + (poll.cost + board[nx][ny]));
                    pq.offer(new Point(nx, ny, poll.cost + board[nx][ny]));
                }
            }
        }
        return res;
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
