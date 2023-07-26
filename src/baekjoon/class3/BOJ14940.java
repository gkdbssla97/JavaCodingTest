package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14940 {
    static int n, m;
    static int[][] board;
    static int[][] _board;
    static boolean[][] visited;
    static boolean[][] _visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        board = new int[n][m];
        _board = new int[n][m];
        visited = new boolean[n][m];

        int res_x = 0;
        int res_y = 0;
        for (int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            Arrays.fill(_board[i], -1);
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(ss[j]);
                if (board[i][j] == 2) {
                    res_x = i;
                    res_y = j;
                } else if(board[i][j] == 0) {
                    _board[i][j] = 0;
                }
            }
        }
        _board[res_x][res_y] = 0;
        bfs(res_x, res_y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(_board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int bfs(int x, int y) {
        _visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));

        while (!q.isEmpty()) {
            Node poll = q.poll();
            _visited[poll.x][poll.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;
                if (0 <= nx && nx < n && 0 <= ny && ny < m
                        && !_visited[nx][ny] && board[nx][ny] != 0) {
                    _visited[nx][ny] = true;
                    _board[nx][ny] = poll.cost + 1;
                    q.offer(new Node(nx, ny, poll.cost + 1));

                }
            }
        }

        return 0;
    }

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
