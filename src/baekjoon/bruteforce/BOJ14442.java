package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14442 {
    static int[][] board;
    static int n, m, k, min = (int) 1e9;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        board = new int[n][m];
        visited = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        visited[0][0][k] = true;
        bfs(0, 0);
        if(min == (int)1e9) {
            System.out.println(-1);
        } else System.out.println(min + 1);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, y, 0, k));
        while (!q.isEmpty()) {
            Node p = q.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                min = Math.min(min, p.cnt);
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (isRange(nx, ny)) {
                    if (board[nx][ny] == 1 && p.k - 1 >= 0 && !visited[nx][ny][p.k - 1]) {
                        visited[nx][ny][p.k - 1] = true;
                        q.offer(new Node(nx, ny, p.cnt + 1, p.k - 1));
                    } else if (board[nx][ny] == 0 && !visited[nx][ny][p.k]) {
                        visited[nx][ny][p.k] = true;
                        q.offer(new Node(nx, ny, p.cnt + 1, p.k));
                    }
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static class Node {
        int x, y, cnt, k;

        public Node(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }
}
