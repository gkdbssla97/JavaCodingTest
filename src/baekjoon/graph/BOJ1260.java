package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.List.*;

public class BOJ1260 {
    static int node;
    static int vertex;
    static int start;
    static int[][] board;
    static boolean[] visited;
    static String line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        vertex = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        board = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < vertex; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
            board[b][a] = 1;
        }
        line = "";
        dfs(start);
        System.out.println(line);

        line = "";
        visited = new boolean[node + 1];
        bfs(start);
        System.out.println(line);
    }
    static void dfs(int n) {
        visited[n] = true;
        line += n + " ";
        for (int i = 1; i <= node; i++) {
            if (!visited[i] && board[n][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            line += poll + " ";
            visited[poll] = true;
            for (int i = 1; i <= node; i++) {
                if (!visited[i] && board[poll][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}
