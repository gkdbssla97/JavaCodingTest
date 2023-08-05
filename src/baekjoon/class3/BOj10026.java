package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOj10026 {
    static String[][] board;
    static boolean[][] visited;
    static boolean[][] _visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int normal = 0;
    static int non_normal = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        visited = new boolean[n][n];
        _visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                board[i][j] = s[j];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && board[i][j].equals("R")) {
                    bfs(i, j, "R");
                    normal++;
                } else if(!visited[i][j] && board[i][j].equals("G")) {
                    bfs(i, j, "G");
                    normal++;
                } else if(!visited[i][j] && board[i][j].equals("B")) {
                    bfs(i, j, "B");
                    normal++;
                    non_normal++;
                }
                if(!_visited[i][j] && (board[i][j].equals("R") || board[i][j].equals("G"))) {
                   _bfs(i, j, "RG");
                    non_normal++;
                }
            }
        }
        System.out.println(normal + " " + non_normal);
    }
    static void bfs(int x, int y, String s) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node p = q.poll();
            visited[p.x][p.y] = true;

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(0 <= nx && nx < board.length && 0 <= ny &&
                ny < board[0].length && !visited[nx][ny]) {
                    if(board[nx][ny].equals(s)) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static void _bfs(int x, int y, String s) {
        String[] ss = s.split("");
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node p = q.poll();
            _visited[p.x][p.y] = true;

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(0 <= nx && nx < board.length && 0 <= ny &&
                ny < board[0].length && !_visited[nx][ny]) {
                    if(board[nx][ny].equals(ss[0]) || board[nx][ny].equals(ss[1])) {
                        _visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static class Node{
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
