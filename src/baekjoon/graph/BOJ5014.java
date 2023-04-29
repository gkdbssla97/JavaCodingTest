package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5014 {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] board;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        F = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        G = Integer.parseInt(s[2]);
        U = Integer.parseInt(s[3]);
        D = Integer.parseInt(s[4]);
        int[] dx = {U, -D};
        visited = new boolean[F + 1];
        board = new int[F + 1];

        bfs(S, dx);
    }
    static void bfs(int start, int[] dx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] =true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            if (poll == G) {
                System.out.println(board[poll]);
                return;
            }
            for (int i = 0; i <= 1; i++) {
                int nx = dx[i] + poll;
                if (1 <= nx && nx <= F && !visited[nx]) {
                    visited[nx] = true;
                    board[nx] = board[poll] + 1;
                    queue.add(nx);
                }
            }
        }
        System.out.println("use the stairs");
    }
}
