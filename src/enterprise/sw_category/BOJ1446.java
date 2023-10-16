package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1446 {
    static int res = 10001;
    static Node[] node;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        node = new Node[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            node[i] = new Node(start, end, cost);
        }
        dfs(0, d, 0);
        System.out.println(res);
    }
    static void dfs(int start, int end, int distance) {
        if(start == end) {
            res = Math.min(res, distance);
            return;
        }
        if(start > end) return;
        for(int i = 0; i < node.length; i++) {
            Node path = node[i];
            if(!visited[i] && path.start == start) {
                visited[i] = true;
                dfs(path.end, end, distance + path.cost);
                visited[i] = false;
            }
        }
        dfs(start + 1, end, distance + 1);
    }
    static class Node {
        int start, end, cost;

        Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
