package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ1504 {
    static int N, E, V1, V2;
    static final int INF = 200_000_000;
    static ArrayList<ArrayList<Node>> board = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);

        for (int i = 0; i < N + 1; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] ss = br.readLine().split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            int c = Integer.parseInt(ss[2]);

            board.get(a).add(new Node(b, c));
            board.get(b).add(new Node(a, c));
        }

        String[] sss = br.readLine().split(" ");
        V1 = Integer.parseInt(sss[0]);
        V2 = Integer.parseInt(sss[1]);

        //start -> V1
        int[] x1 = dijkstra(1);
        //V1 -> V2
        int[] y1 = dijkstra(V1);
        //V2 -> N
        int[] z1 = dijkstra(V2);

        long res1 = x1[V1] + y1[V2] + z1[N];

        //start -> V2
        int[] x2 = dijkstra(1);
        //V2 -> V1
        int[] y2 = dijkstra(V2);
        //V1 -> N
        int[] z2 = dijkstra(V1);

        long res2 = x2[V2] + y2[V1] + z2[N];

        if (res1 >= INF && res2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(res1, res2));
        }
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (curNode.cost > dist[curNode.idx]) {
                continue;
            }

            for (int i = 0; i < board.get(curNode.idx).size(); i++) {
                Node nextNode = board.get(curNode.idx).get(i);

                if (dist[nextNode.idx] > nextNode.cost + curNode.cost) {
                    dist[nextNode.idx] = nextNode.cost + curNode.cost;
                    pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
        return dist;
    }

    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
