package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5427 {
    static int T, n, m;
    static String[][] board;
    static Queue<Node> fires;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            board = new String[n][m];
            visited = new boolean[n][m][2];
            Node person = null;
            fires  = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                s = br.readLine().split("");
                for(int j = 0; j < m; j++) {
                    board[i][j] = s[j];
                    if(board[i][j].equals("@")) {
                        board[i][j] = ".";
                        person = new Node(i, j, 0, 0);
                        visited[i][j][0] = true;
                    } else if(board[i][j].equals("*")) {
                        board[i][j] = ".";
                        fires.offer(new Node(i, j, 1, 0));
                        visited[i][j][1] = true;
                    }
                }
            }
            fires.offer(person);
            /**
             * type = 0 -> 상근
             * type = 1 -> 불
             * */
            int res = bfs();
            if(res == -1) {
                System.out.println("IMPOSSIBLE");
            } else System.out.println(res);
        }
    }
    static int bfs() {
        while(!fires.isEmpty()) {
            Node p = fires.poll();

            if(p.type == 0 && isExited(p.x, p.y)) {
//                System.out.println("EXIT -> " + p.x + " " + p.y);
                return p.cnt + 1;
            }
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(isRange(nx, ny) && board[nx][ny].equals(".")) {
                    // 불인가?
                    if(p.type == 1 && !visited[nx][ny][p.type]) {
                        visited[nx][ny][p.type] = true;
                        fires.offer(new Node(nx, ny, p.type, p.cnt + 1));
                    }
                    // 상근인가?
                    else if(p.type == 0) {
                        if(visited[nx][ny][p.type] || visited[nx][ny][1]) continue;
                        visited[nx][ny][0] = true;
                        fires.offer(new Node(nx, ny, p.type, p.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }
    static boolean isExited(int x, int y) {
        return board[x][y].equals(".") &&
                (x == 0 || x == n - 1) || (y == 0 || y == m - 1);
    }
    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    static class Node {
        int x, y, type, cnt;

        public Node(int x, int y, int type, int cnt) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.cnt = cnt;
        }
    }
}
