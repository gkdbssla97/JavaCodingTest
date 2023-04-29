package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int node, vertex;
    static int[][] board;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        vertex = Integer.parseInt(br.readLine());
        board = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < vertex; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            board[a][b] = 1;
            board[b][a] = 1;
        }

        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= node; i++) {
            if (!visited[i] && board[start][i] == 1) {
                visited[i] = true;
                cnt++;
//                System.out.println("start: i: " + start + " " + i);
                dfs(i);
//                visited[i] = false;
                //return;
            }
        }
    }
}
