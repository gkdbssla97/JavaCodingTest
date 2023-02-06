package programmers.summerwintercoding;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 배달 {
    static int N;
    static int K;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static boolean[] visited;

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList<ArrayList<Node>>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>
                ((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(1, 0));
        dist[1] = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (dist[poll.idx] < poll.cost)
                continue;
            for (int i = 0; i < graph.get(poll.idx).size(); i++) {
                Node nextNode = graph.get(poll.idx).get(i);
                if (dist[nextNode.idx] > poll.cost + nextNode.cost) {
                    dist[nextNode.idx] = poll.cost + nextNode.cost;
                    queue.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

//        for (int x : dist) {
//            if (x <= K)
//                answer++;
//        }
//        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        N = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        K = 3;

        solution(N, road, K);
    }
}
