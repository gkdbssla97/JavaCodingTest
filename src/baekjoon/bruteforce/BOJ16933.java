package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ16933 {
    static int[][] board;
    static int n, m, k, ans;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m][k + 1][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        ans = -1;
        bfs();

        System.out.println(ans);

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(0, 0, 1, 0, 0));
        visited[0][0][0][0] = true;
        while (!q.isEmpty()) {
            Node p = q.poll();

            int x = p.x;
            int y = p.y;

            if (x == n - 1 && y == m - 1) {
                ans = p.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 > nx || nx >= n || 0 > ny || ny >= m) continue;
                if (board[nx][ny] == 0) {
                    if (p.time == 0 && !visited[nx][ny][p.bCnt][p.time + 1]) {
                        q.add(new Node(nx, ny, p.cnt + 1, p.bCnt, p.time + 1));
                        visited[nx][ny][p.bCnt][p.time + 1] = true;
                    } else if (p.time == 1 && !visited[nx][ny][p.bCnt][p.time - 1]) {
                        q.add(new Node(nx, ny, p.cnt + 1, p.bCnt, p.time - 1));
                        visited[nx][ny][p.bCnt][p.time - 1] = true;
                    }
                } else {
                    if (p.bCnt < k && p.time == 0 && !visited[nx][ny][p.bCnt + 1][p.time + 1]) {
                        visited[nx][ny][p.bCnt + 1][p.time + 1] = true;
                        q.add(new Node(nx, ny, p.cnt + 1, p.bCnt + 1, p.time + 1));
                    } else if (p.bCnt < k && p.time == 1 && !visited[x][y][p.bCnt][p.time - 1]) {
                        visited[x][y][p.bCnt][p.time - 1] = true;
                        q.add(new Node(x, y, p.cnt + 1, p.bCnt, p.time - 1));
                    }
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static class Node {
        int x, y, cnt, bCnt, time;

        public Node(int x, int y, int cnt, int bCnt, int time) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.bCnt = bCnt;
            this.time = time;
        }
    }
}
