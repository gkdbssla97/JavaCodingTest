package baekjoon.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ1240 {
    static int n, m;
    static int[] dist;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            arr.get(start).add(new Node(end, cost));
            arr.get(end).add(new Node(start, cost));
        }

        for(int i = 0; i < m; i++) {
            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            dist[start] = 0;
            dfs(start, end);
            System.out.println(dist[end]);
        }
    }

    static void dfs(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node p = pq.poll();

            if (dist[p.end] < p.cost) continue;
            for (int i = 0; i < arr.get(p.end).size(); i++) {
                Node next = arr.get(p.end).get(i);
                if(dist[next.end] > next.cost + p.cost) {
                    dist[next.end] = next.cost + p.cost;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
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
