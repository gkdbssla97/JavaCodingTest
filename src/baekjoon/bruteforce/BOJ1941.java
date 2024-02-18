package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ1941 {
    static String[][] board = new String[5][5];
    static boolean[][] visited;
    static int res = 0;
    static int[] selected = new int[7];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < 5; j++) {
                board[i][j] = s[j];
            }
        }
        combination(24, 7, 0, 0);
        System.out.println(res);
    }

    static void combination(int n, int r, int start, int cnt) {
        if (r == cnt) {
//            System.out.println(Arrays.toString(selected));
            visited = new boolean[5][5];
            bfs(selected[0]);
            return;
        }
        for (int i = start; i <= n; i++) {
            selected[cnt] = i;
            combination(n, r, i + 1, cnt + 1);
        }
//        System.out.println(res);
    }

    static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        int match = 0;
        int cnt = 1;
        int x = start / 5;
        int y = start % 5;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node p = q.poll();
            if (board[p.x][p.y].equals("S")) {
                match++;
            }
            for (int i = 1; i < 7; i++) {
                int nx = selected[i] / 5;
                int ny = selected[i] % 5;
                if (!visited[nx][ny] && isNearBy(p, selected[i])) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    cnt++;
                }
            }
        }


        if (cnt == 7) {
            if (match >= 4) {
                res++;
            }
        }
    }

    static boolean isNearBy(Node cur, int next) {
        int nx = next / 5;
        int ny = next % 5;
        return Math.abs(cur.x - nx) + Math.abs(cur.y - ny) == 1;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
