package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.List.*;

public class BOJ1260 {
    static boolean[] visited;
    static int[][] vertex;
    static int node, testCase, start;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        node = Integer.parseInt(s[0]);
        testCase = Integer.parseInt(s[1]);
        start = Integer.parseInt(s[2]);

        vertex = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            vertex[a][b] = vertex[b][a] = 1;
        }

        result = "";
        dfs(start);
        System.out.println(result);
        visited = new boolean[node + 1];
        result = "";
        bfs(start);
        System.out.println(result);
    }

    public static void dfs(int start) {
        visited[start] = true;
        result += start + " ";
        for (int i = 1; i <= node; i++) {
            if (vertex[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result += poll + " ";
            for (int j = 1; j <= node; j++) {
                if (!visited[j] && vertex[poll][j] == 1) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
