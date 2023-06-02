package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2468 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int max_val = 0;
        int min_val = 101;
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
                if(max_val < board[i][j]) {
                    max_val = board[i][j];
                }
                if(min_val > board[i][j]) {
                    min_val = board[i][j];
                }
            }
        }
//        System.out.println("max: min: " + max_val + " " + min_val);
        for(int k = 0; k <=max_val; k++) {
            visited = new boolean[N][N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && board[i][j] > k) {
                        visited[i][j] = true;
//                        System.out.println("i,j " + i + " " + j);
                        cnt += bfs(i, j, k);
                    }
                }
            }
            if(res <= cnt) {
//                System.out.println("cnt: " + cnt + " " + k);
                res = cnt;
            }
        }
        System.out.println(res);
    }
    static int bfs(int x, int y, int height) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point poll = q.poll();
            visited[poll.x][poll.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < N &&
                        !visited[nx][ny] && board[nx][ny] > height) {
                    visited[nx][ny] = true;
//                    cnt += 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return 1;
    }
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
