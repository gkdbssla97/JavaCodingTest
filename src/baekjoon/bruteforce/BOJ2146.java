package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2146 {
    static int[][] board, island, side;
    static boolean[][] visited;
    static int[][] vIsland;
    static int n, number, min = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> arr = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        island = new int[n][n];
        side = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        // 섬 번호 매기기 && 가장자리 찾기
        number = 1;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    island[i][j] = number;
                    bfs(i, j);
                    number++;
                }
            }
        }
//        print(side);
        vIsland = new int[n][n];
        findOtherIsland();
        System.out.println(min);
    }

    static void findOtherIsland() {
        while (!arr.isEmpty()) {
            Node p = arr.poll();
//            System.out.println("x, y -> " + p.x + " " + p.y);
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (isRange(nx, ny)) {
                    if (island[nx][ny] == 0) {
                        vIsland[nx][ny] = p.cnt + 1;
                        island[nx][ny] = p.type;
                        arr.offer(new Node(nx, ny, p.type, p.cnt + 1));
                    } else if(island[nx][ny] > 0 && island[nx][ny] != p.type){
                        min = Math.min(min, vIsland[p.x][p.y] + vIsland[nx][ny]);
                    }
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node p = q.poll();
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if (isRange(nx, ny) && !visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    island[nx][ny] = number;
                }
                if (isRange(nx, ny) && board[nx][ny] == 0) {
                    cnt++;
                }
            }
            if (cnt > 0) {
                arr.add(new Node(p.x, p.y, number, 0));
                side[p.x][p.y] = 1;
            }
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static class Node {
        int x, y, type, cnt;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int type, int cnt) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.cnt = cnt;
        }
    }

    static void print(int[][] board) {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
