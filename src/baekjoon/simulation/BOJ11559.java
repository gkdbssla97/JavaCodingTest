package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11559 {
    static String[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n = 12, m = 6;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = s[j];
            }
        }
        int res = 0;
        while(true) {
            if(findBlock()) {
                res++;
                moveBlock();
            } else {
                break;
            }
//            printBlock();
        }
        System.out.println(res);
    }

    static boolean findBlock() {
        boolean flag = false;
        boolean[][] visited = new boolean[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (!board[i][j].equals(".") && !visited[i][j]) {
                    visited[i][j] = true;
                    int cnt = bfs(i, j, visited);
                    if (cnt >= 4) {

                        deleteBlock(i, j);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
    static void print(boolean[][] visited) {
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    static void printBlock() {
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
    static int bfs(int x, int y, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        int cnt = 1;
        while (!q.isEmpty()) {
            Node p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    if (board[p.x][p.y].equals(board[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                        cnt++;
                    }
                }
            }
        }
//        System.out.println("cnt : " + cnt);
        return cnt;
    }

    static void deleteBlock(int x, int y) {
        boolean[][] bomb = new boolean[n][m];
        String color = board[x][y];
        board[x][y] = ".";
        bomb[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while (!q.isEmpty()) {
            Node p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (isRange(nx, ny) && !bomb[nx][ny] && board[nx][ny].equals(color)) {
                    bomb[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    board[nx][ny] = ".";
                }
            }
        }
    }
    static void moveBlock() {
        //  총 6개의 열을 모두 확인해본다.
        for(int i = 0; i < m; i++) {
            Queue<String> q = new LinkedList<>();
            for(int j = n - 1; j >= 0; j--) {
                if(board[j][i].equals(".")) {
                    continue;
                }
                q.offer(board[j][i]);

            }
            if(q.isEmpty()) continue;
            int idx = 0;
            while(!q.isEmpty()) {
                String poll = q.poll();
                board[n - 1 - idx][i] = poll;
                idx++;
            }
            for(int j = 0; j < n - idx; j++) {
                board[j][i] = ".";
            }
        }
    }
    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
