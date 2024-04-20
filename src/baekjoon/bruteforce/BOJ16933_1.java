package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ16933_1 {
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visited;
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] a = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = a[j];
            }
        }
        int result = bfs(0, 0);
        System.out.println(result);
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1, 0, 0));

        int day = 0; // 짝수: 낮, 홀수: 밤

        visited = new boolean[n][m][2][k + 1];
        while (!q.isEmpty()) {
            Node p = q.poll();
            visited[p.x][p.y][p.day % 2][p.attack] = true;

            if (isExit(p)) {
                return p.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (isRange(nx, ny)) {
                    // 낮
                    if (p.day % 2 == 0) {
                        // 바위 O
                        if (board[nx][ny] != 0) {
                            if (p.attack < k && !visited[nx][ny][(p.day  + 1) % 2][p.attack + 1]) {
                                visited[nx][ny][(p.day  + 1) % 2][p.attack + 1] = true;
                                q.offer(new Node(nx, ny, p.cnt + 1, p.attack + 1, (p.day  + 1) % 2));
                            }
                        }
                        // 바위 X
                        else {
                            if(!visited[nx][ny][(p.day  + 1) % 2][p.attack]) {
                                visited[nx][ny][(p.day  + 1) % 2][p.attack] = true;
                                q.offer(new Node(nx, ny, p.cnt + 1, p.attack, (p.day  + 1) % 2));
                            }
                        }
                    }
                    // 밤
                    else {
                        // 바위 X
                        if (board[nx][ny] == 0 && !visited[nx][ny][(p.day  + 1) % 2][p.attack]) {
                            visited[nx][ny][(p.day  + 1) % 2][p.attack] = true;
                            q.offer(new Node(nx, ny, p.cnt + 1, p.attack, (p.day + 1) % 2));
                        }
                    }
                }
            }
            if(!visited[p.x][p.y][(p.day  + 1) % 2][p.attack]) {
                visited[p.x][p.y][(p.day  + 1) % 2][p.attack] = true;
                q.offer(new Node(p.x, p.y, p.cnt + 1, p.attack, (p.day  + 1) % 2));
            }
        }

        return -1;
    }

    static boolean isExit(Node node) {
        return node.x == n - 1 && node.y == m - 1;
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static class Node {
        int x, y, cnt, attack, day;

        public Node(int x, int y, int cnt, int attack, int day) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.attack = attack;
            this.day = day;
        }
    }
}