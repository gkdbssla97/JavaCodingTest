package programmers.kakao.TECHINTERNSHIP2022;

import java.util.*;

public class 등산코스정하기1 {
    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        ArrayList<ArrayList<Node>> graph;
        HashMap<Integer, Boolean> summitMap = createSummitMap(summits);
        HashMap<Integer, Boolean> gateMap = createGateMap(gates);
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        Arrays.sort(summits);

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            graph.get(path[0]).add(new Node(path[1], path[2]));
            graph.get(path[1]).add(new Node(path[0], path[2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int gate : gates) {
            q.offer(new Node(gate, 0));
            dist[gate] = 0;
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            System.out.println(now.idx + " " + now.cost);

            if (gateMap.containsKey(now.idx) || summitMap.containsKey(now.idx)) {
                continue;
            }

            if (dist[now.idx] < now.cost) {
                continue;
            }

            for (Node next : graph.get(now.idx)) {
                int intensity =
                        (next.cost == Integer.MAX_VALUE) ? now.cost : Math.max(next.cost, now.cost);
                if (dist[next.idx] > intensity) {
                    dist[next.idx] = intensity;
                    q.offer(new Node(next.idx, intensity));
                }
            }
        }

        int index = -1;
        int minIntensity = Integer.MAX_VALUE;
        for (int summit : summits) {
            if (dist[summit] < minIntensity) {
                minIntensity = dist[summit];
                index = summit;
            }
        }
        System.out.println("idx : min : " + " " + index + " " + minIntensity);
        return new int[]{index, minIntensity};
    }


    private static HashMap<Integer, Boolean> createGateMap(int[] gates) {
        HashMap<Integer, Boolean> gateMap = new HashMap<>();
        for (int gate : gates) {
            gateMap.put(gate, true);
        }
        return gateMap;
    }

    private static HashMap<Integer, Boolean> createSummitMap(int[] summits) {
        HashMap<Integer, Boolean> summitMap = new HashMap<>();
        for (int summit : summits) {
            summitMap.put(summit, true);
        }

        return summitMap;
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
        solution(n, paths, gates, summits);
    }
}
