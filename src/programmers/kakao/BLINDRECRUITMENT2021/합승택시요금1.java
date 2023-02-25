package programmers.kakao.BLINDRECRUITMENT2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승택시요금1 {

    static class Edge {
        int idx;
        int cost;

        public Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static final int max_val = 200 * 100000 + 1;
    static ArrayList<ArrayList<Edge>> graph;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] i : fares) {
            graph.get(i[0]).add(new Edge(i[1], i[2]));
            graph.get(i[1]).add(new Edge(i[0], i[2]));
        }
        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];

        Arrays.fill(startA, max_val);
        Arrays.fill(startB, max_val);
        Arrays.fill(start, max_val);

        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);

        System.out.println(Arrays.toString(startA));
        System.out.println(Arrays.toString(startB));
        System.out.println(Arrays.toString(start));

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }
        System.out.println(answer);
        return answer;
    }

    static int[] dijkstra(int start, int [] costs) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        pq.offer(new Edge(start, 0));
        costs[start] = 0;

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int curIdx = poll.idx;
            int curCost = poll.cost;

            if(curCost > costs[curIdx]) continue;

            ArrayList<Edge> edges = graph.get(curIdx);
            for (Edge edge : edges) {
                int cost = edge.cost + costs[curIdx];

                if (cost < costs[edge.idx]) {
                    costs[edge.idx] = cost;
                    pq.offer(new Edge(edge.idx, cost));
                }
            }
        }
        return costs;
    }
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66},
                {2, 3, 22}, {1, 6, 25}};
        solution(n, s, a, b, fares);

    }
}
