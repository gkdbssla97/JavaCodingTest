//package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v = array[0]; // 3
            int e = array[1]; // 2
            List<ArrayList<Integer>> graph = new ArrayList<>();
            boolean[] visited = new boolean[v];
            int[] paint = new int[v];
            for (int k = 0; k < v; k++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int v1 = array[0] - 1;
                int v2 = array[1] - 1;
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            boolean ans = true;
            for(int l = 0; l < v; l++) {
                if(visited[l]) continue;
                if(bfs(l, paint, visited, graph) == -1) {
                    ans = false;
                }
            }
            System.out.println(ans ? "YES" : "NO");
        }
    }

    public static int bfs(int start, int[] paint, boolean[] visited, List<ArrayList<Integer>> graph) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 1));
        paint[start] = 1;
        visited[start] = true;
        while (!q.isEmpty()) {
            Node p = q.poll();
            for (int i = 0; i < graph.get(p.next).size(); i++) {
                Integer next = graph.get(p.next).get(i);
                if (visited[next]) {
                    // 칠해져 있으면 같은 색인지 확인해야한다.
                    if(paint[next] == paint[p.next]) {
                        return -1;
                    }
                } else {
                    visited[next] = true;
                    paint[next] = p.color * -1;
                    q.offer(new Node(next, p.color * -1));
                }
            }
        }
        return 1;
    }

    public static class Node {
        int next, color;

        public Node(int next, int color) {
            this.next = next;
            this.color = color;
        }
    }
}
