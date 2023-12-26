package baekjoon.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ1916 {
    static int n, m;
    static int[] dist;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Node>());
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            arr.get(start).add(new Node(end, cost));
        }
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        dijkstra(a);
        System.out.println(dist[b]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost > dist[node.end]) continue;

            for (int i = 0; i < arr.get(node.end).size(); i++) {
                Node next = arr.get(node.end).get(i);
                if (node.cost + next.cost < dist[next.end]) {
                    dist[next.end] = node.cost + next.cost;
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
