package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1600 {
    static int k, n, m, min = (int)1e9;
    static int[][] board;
    static int[] dx1 = {-1, 0, 1, 0};
    static int[] dy1 = {0, 1, 0, -1};
    static int[] dx2 = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy2 = {-1, 1, -2, 2, -2, 2, -1, 1};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        board = new int[n][m];
        visited = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        visited[0][0][k] = true;
        int res = bfs(0, 0);
        System.out.println(res);
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, k));

        while (!q.isEmpty()) {
            Node p = q.poll();
            if (p.x == n - 1 && p.y == m - 1) {
                min = Math.min(min, p.cnt);
            }

            if (p.kCnt - 1 >= 0) { // 말
                for (int i = 0; i < 8; i++) {
                    int nx = dx2[i] + p.x;
                    int ny = dy2[i] + p.y;
                    if (isRange(nx, ny) && board[nx][ny] == 0 && !visited[nx][ny][p.kCnt - 1]) {
                        visited[nx][ny][p.kCnt - 1] = true;
                        q.offer(new Node(nx, ny, p.cnt + 1, p.kCnt - 1));
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx1[i] + p.x;
                int ny = dy1[i] + p.y;
                if (isRange(nx, ny) && board[nx][ny] == 0 && !visited[nx][ny][p.cnt]) {
                    visited[nx][ny][p.cnt] = true;
                    q.offer(new Node(nx, ny, p.cnt + 1, p.kCnt));
                }
            }
        }

        return min == (int)1e9 ? -1 : min;
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static class Node {
        int x, y, cnt, kCnt;

        public Node(int x, int y, int cnt, int kCnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.kCnt = kCnt;
        }
    }
}
