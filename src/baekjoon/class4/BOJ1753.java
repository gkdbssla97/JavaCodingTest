package baekjoon.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ1753 {
    static int v, e, start;
    static int[] dist;
    static ArrayList<ArrayList<Node>> board = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        start = Integer.parseInt(br.readLine());

        dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= v; i++) {
            board.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            board.get(u).add(new Node(v, w));
        }
        dijkstra(start);
        for(int i = 1; i <= v; i++) {
            if(i == start) System.out.println(0);
            else if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node p = pq.poll();

            if(p.cost > dist[p.end]) {
                continue;
            }
            for(int i = 0; i < board.get(p.end).size(); i++) {
                Node next = board.get(p.end).get(i);
                if(dist[next.end] > p.cost + next.cost) {
                    dist[next.end] = p.cost + next.cost;
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
