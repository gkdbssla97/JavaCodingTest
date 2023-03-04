package programmers.kakao.TECHINTERNSHIP2022;

import java.util.*;

public class 등산코스정하기 {
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            if (isGate(path[0], gates) || isSummit(path[1], summits))
                graph.get(path[0]).add(new Node(path[1], path[2]));
            else if (isGate(path[1], gates) || isSummit(path[0], summits))
                graph.get(path[1]).add(new Node(path[0], path[2]));
            else {
                graph.get(path[0]).add(new Node(path[1], path[2]));
                graph.get(path[1]).add(new Node(path[0], path[2]));
            }
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        for (int gate : gates) {
            q.offer(new Node(gate, 0));
            dist[gate] = 0;
        }

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if (dist[curNode.idx] < curNode.cost) continue;

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nextNode = graph.get(curNode.idx).get(i);

                int dis = Math.max(dist[curNode.idx], nextNode.cost);
                if (dist[nextNode.idx] > dis) {
                    dist[nextNode.idx] = dis;
                    q.offer(new Node(nextNode.idx, dis));
                }
            }
        }

        int res_summit = Integer.MAX_VALUE;
        int res_intensity = Integer.MAX_VALUE;

        Arrays.sort(summits);

        for (int summit : summits) {
            if (dist[summit] < res_intensity) {
                res_summit = summit;
                res_intensity = dist[summit];
            }
        }
        System.out.println(res_summit + " " + res_intensity);
        return new int[]{res_summit, res_intensity};
        
    }

    static boolean isGate(int idx, int[] gates) {
        for (int gate : gates) {
            if (idx == gate) return true;
        }
        return false;
    }

    static boolean isSummit(int idx, int[] summits) {
        for (int summit : summits) {
            if (idx == summit) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int n = 6;
//        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2},
//                {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1},
//                {5, 6, 1}};
//        int[] gates = {1, 3};
//        int[] summits = {5};
        int n = 7;
        int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3},
                {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
        int[] gates = {1};
        int[] summits = {2, 3, 4};
        System.out.println(Arrays.toString(solution(n, paths, gates, summits)));
    }
}
