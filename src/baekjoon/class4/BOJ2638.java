package baekjoon.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2638 {
    static int n, m, cnt = 0;
    static int[][] board, copy;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
                if (board[i][j] != 0) cnt++;
            }
        }
        int answer = 0;
        int idx = 0;
        while (cnt != 0) {
            idx++;
            visited = new boolean[n][m];
            copy = new int[n][m];
            bfs(0, 0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] >= 2) {
                        cnt--;
                        board[i][j] = 0;
                    }
                }
            }
            answer++;
//            print();
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (isRange(nx, ny)) {
                    if (board[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    } else if(board[nx][ny] != 0) {
                        copy[nx][ny]++;
                    }
                }
            }
        }
    }


    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(copy[i]));
        }
        System.out.println("----");
    }

    static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = board[i][j];
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
