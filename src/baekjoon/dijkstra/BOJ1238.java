package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static int[] dist_go_party;
    static int[] dist_go_home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Node>>();

        dist_go_home = new int[N + 1];
        dist_go_party = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            dist_go_party[i] = Integer.MAX_VALUE;
            dist_go_home[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        // go_home
        PriorityQueue<Node> queue_go_home = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue_go_home.offer(new Node(X, 0));
        dist_go_home[X] = 0;
        while (!queue_go_home.isEmpty()) {
            Node poll = queue_go_home.poll();
            if (dist_go_home[poll.idx] < poll.cost)
                continue;
            for (int k = 0; k < graph.get(poll.idx).size(); k++) {
                Node nextNode = graph.get(poll.idx).get(k);
                if (dist_go_home[nextNode.idx] > poll.cost + nextNode.cost) {
                    dist_go_home[nextNode.idx] = poll.cost + nextNode.cost;
                    queue_go_home.offer(new Node(nextNode.idx, dist_go_home[nextNode.idx]));
                }
            }
        }

//        System.out.println(Arrays.toString(dist_go_home));
//        System.out.println("------------");

        int max_val = 0;
//        // go_party
        for (int i = 1; i <= N; i++) {
            for (int y = 0; y < N + 1; y++) {
                dist_go_party[y] = Integer.MAX_VALUE;
            }
            PriorityQueue<Node> queue_go_party = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
            queue_go_party.offer(new Node(i, 0));
            dist_go_party[i] = 0;
            while (!queue_go_party.isEmpty()) {
                Node poll = queue_go_party.poll();
                if (dist_go_party[poll.idx] < poll.cost)
                    continue;
                for (int j = 0; j < graph.get(poll.idx).size(); j++) {
                    Node nextNode = graph.get(poll.idx).get(j);
                    if (dist_go_party[nextNode.idx] > poll.cost + nextNode.cost) {
                        dist_go_party[nextNode.idx] = poll.cost + nextNode.cost;
                        queue_go_party.offer(new Node(nextNode.idx, dist_go_party[nextNode.idx]));
                    }
                }
            }
//
//            System.out.println("번호: " + i);
//            System.out.println(Arrays.toString(dist_go_party));
//            System.out.println("------------");
            if (dist_go_party[X] + dist_go_home[i] > max_val) {
                max_val = dist_go_party[X] + dist_go_home[i];
            }
        }
        System.out.println(max_val);
    }
}
