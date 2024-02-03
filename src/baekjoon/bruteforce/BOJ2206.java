package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2206 {
    static int n, m;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1, 0));

        while (!q.isEmpty()) {
            Node p = q.poll();
            visited[p.x][p.y][0] = true;
            if(p.x == n - 1 && p.y == m - 1) {
                return p.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(isRange(nx, ny) && !visited[nx][ny][p.isRock]) {
                    if(board[nx][ny] == 1 && p.isRock == 0) {
                        visited[nx][ny][p.isRock] = true;
                        q.offer(new Node(nx, ny, p.cnt + 1, 1));
                    } else if(board[nx][ny] == 0){
                        visited[nx][ny][p.isRock] = true;
                        q.offer(new Node(nx, ny, p.cnt + 1, p.isRock));
                    }
                }
            }
        }
        return -1;
    }
    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    static class Node {
        int x, y, cnt, isRock;

        Node(int x, int y, int cnt, int isRock) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isRock = isRock;
        }
    }
}
