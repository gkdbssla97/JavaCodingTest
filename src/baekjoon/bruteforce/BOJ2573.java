package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2573 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] board = new int[n][m];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        int time = 0;
        while(true) {
            time++;
            int[][] visited = new int[n][m];
            // 로직
            int totalCnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] > 0) {
                        totalCnt++;
                        int cnt = 0;
                        for(int dir = 0; dir < 4; dir++) {
                            int nx = dx[dir] + i;
                            int ny = dy[dir] + j;
                            if(isRange(nx, ny, n, m)) {
                                if(board[nx][ny] == 0) {
                                    cnt++;
                                }
                            }
                        }
                        if(board[i][j] - cnt <= 0) {
                            visited[i][j] = board[i][j];
                        } else {
                            visited[i][j] = cnt;
                        }
                    }
                }
            }
            if(totalCnt == 0) {
                System.out.println(0);
                return;
            }
//            printV(visited, n, m);
            // 빙산 녹은만큼 값 초기화
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] != 0 && visited[i][j] > 0) {
                        board[i][j] -= visited[i][j];
                    }
                }
            }
            // 빙산 2개 이상인가?
            boolean[][] v = new boolean[n][m];
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] > 0 && !v[i][j]) {
                        v[i][j] = true;
                        bfs(i, j, n, m, board, v);
                        cnt++;
                        if(cnt >= 2) {
                            System.out.println(time);
                            System.exit(0);
                        }
                    }
                }
            }
//            print(board, n, m);
        }
    }
    static void bfs(int x, int y, int n, int m, int[][] board, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if(isRange(nx, ny, n, m) && !visited[nx][ny] && board[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
    static boolean isRange(int x, int y, int n, int m) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    static void print(int[][] board, int n, int m) {
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("---");
    }
    static void printV(int[][] visited, int n, int m) {
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println("---");
    }
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
