package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ21736 {
    static String[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new String[n][m];
        visited = new boolean[n][m];

        int x = 0;
        int y = 0;
        ans = 0;
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                board[i][j] = ss[j];
                if(board[i][j].equals("I")) {
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x, y);
        if(ans == 0) {
            System.out.println("TT");
        } else System.out.println(ans);
    }
    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node p = q.poll();
            visited[p.x][p.y] = true;

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(0 <= nx && nx < n && 0 <= ny && ny < m
                    && !visited[nx][ny]) {
                    if(board[nx][ny].equals("O")) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    } else if(board[nx][ny].equals("P")) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                        ans++;
                    }
                }
            }
        }
    }
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
