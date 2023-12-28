package baekjoon.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1967 {
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static boolean[] visited;
    static int max = -1;
    static int far = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            arr.get(start).add(new Node(end, cost));
            arr.get(end).add(new Node(start, cost));
        }
        visited[1] = true;
        dfs(1, 0);
        visited = new boolean[n + 1];
        max = -1;
        visited[far] = true;
        dfs(far, 0);
        System.out.println(max);
    }
    static void dfs(int start, int cost) {
        if(max < cost) {
            max = cost;
            far = start;
        }

        for(int i = 0; i < arr.get(start).size(); i++) {
            Node node = arr.get(start).get(i);
            if(!visited[node.end]) {
                visited[node.end] = true;
                dfs(node.end, cost + node.cost);
            }
        }
    }
    static class Node {
        int end, cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
