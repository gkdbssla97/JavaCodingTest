package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1926 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(s[j]);
                board[i][j] = v;
            }
        }
        int cnt = 0;
        int max = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    visited[i][j] = true;
                    int v = bfs(i, j, n, m);
                    if(v > 0) {
                        cnt++;
                        max = Math.max(max, v);
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
//        print(n);
    }

    public static int bfs(int x, int y, int n, int m) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        int max = 1;
        while (!q.isEmpty()) {
            Node p = q.poll();
            max = Math.max(max, p.cnt);
            visited[p.x][p.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (isRange(nx, ny, n, m) && !visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, 0));
                    max++;
                }
            }
        }
        return max;
    }
    static void print(int n) {
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }
    public static boolean isRange(int x, int y, int n, int m) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}

