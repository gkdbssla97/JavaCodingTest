package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

public class BOJ1238_1 {
    static int N, M, X;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static int[] goDist;
    static int[] arriveDist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        goDist = new int[N + 1];
        Arrays.fill(goDist, Integer.MAX_VALUE);
        arriveDist = new int[N + 1];
        Arrays.fill(arriveDist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            arr.get(start).add(new Node(e, c));
        }

        int max = -1;
        int[] res = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            goDist = new int[N + 1];
            Arrays.fill(goDist, Integer.MAX_VALUE);
            goDist[i] = 0;
            dijkstra(i, goDist);
            res[i] = goDist[X];
        }
        arriveDist = new int[N + 1];
        Arrays.fill(arriveDist, Integer.MAX_VALUE);
        arriveDist[X] = 0;
        dijkstra(X, arriveDist);
//        System.out.println(Arrays.toString(res));
        for(int i = 1; i <= N; i++) {
            int v = res[i] + arriveDist[i];
            max = Math.max(v, max);
        }

        System.out.println(max);
    }
    static void dijkstra(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dist[cur.end]) continue;

            for(int i = 0; i < arr.get(cur.end).size(); i++) {
                Node next = arr.get(cur.end).get(i);
                if(dist[next.end] > dist[cur.end] + next.cost) {
                    dist[next.end] = dist[cur.end] + next.cost;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
    static class Node {
        int end, cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
