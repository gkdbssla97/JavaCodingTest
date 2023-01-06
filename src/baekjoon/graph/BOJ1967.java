package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1967 {
    static ArrayList<Node> []list;
    static int N;
    static int ans;
    static boolean[] visited;

    static class Node {
        int node, dist;

        public Node(int num, int dist) {
            this.node = num;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }
        ans = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(ans);
    }

    static void dfs(int num, int dim) {
        for (Node n : list[num]) {
            if (!visited[n.node]) {
                visited[n.node] = true;
                dfs(n.node, dim + n.dist);
            }
        }
        ans = Math.max(ans, dim);
    }
}
