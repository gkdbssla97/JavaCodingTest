package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ10282 {
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int timer = 0, cnt = 0;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // V
            int d = Integer.parseInt(st.nextToken()); // E
            int c = Integer.parseInt(st.nextToken()); // X
            dist = new int[n + 1];
            graph = new ArrayList<ArrayList<Node>>();

            for (int k = 0; k < n + 1; k++) {
                graph.add(new ArrayList<>());
                dist[k] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // end
                int b = Integer.parseInt(st.nextToken()); // start
                int s = Integer.parseInt(st.nextToken()); // cost
                graph.get(b).add(new Node(a, s));
            }
            PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
            queue.offer(new Node(c, 0));
            dist[c] = 0;
            while (!queue.isEmpty()) {
                Node poll = queue.poll();

//                System.out.println("CurNode: " + poll.idx);
                if (dist[poll.idx] < poll.cost)
                    continue;
                for (int x = 0; x < graph.get(poll.idx).size(); x++) {
                    Node nextNode = graph.get(poll.idx).get(x);
                    if (dist[nextNode.idx] > poll.cost + nextNode.cost) {
                        dist[nextNode.idx] = poll.cost + nextNode.cost;
                        queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                    }
                }
            }
            for (int v = 1; v <= n; v++) {
                if (dist[v] != Integer.MAX_VALUE) {
                    cnt++;
                    timer = Math.max(timer, dist[v]);
                }
            }
            System.out.println(cnt + " " + timer);
        }
    }
}
