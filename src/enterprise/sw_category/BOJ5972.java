package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ5972 {
    static int n, m;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, (int)1e9);
        // 시간복잡도 VlogE <= 1억 이하
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            arr.get(start).add(new Node(end, cost));
            arr.get(end).add(new Node(start, cost));
        }

        distance[1] = 0;
        dijkstra(1);
//        System.out.println(Arrays.toString(distance));
        System.out.println(distance[n]);
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node p = pq.poll();

            if(p.cost > distance[p.end]) continue;

            for(int i = 0; i < arr.get(p.end).size(); i++) {
                Node next = arr.get(p.end).get(i);

                if(distance[next.end] > next.cost + p.cost) {
                    distance[next.end] = next.cost + p.cost;
                    pq.offer(new Node(next.end, distance[next.end]));
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
