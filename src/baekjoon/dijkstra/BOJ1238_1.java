package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1238_1 {
    static int N, M, X;
    static ArrayList<Integer> res = new ArrayList<>();
    static int[] home;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        home = new int[N + 1];
        for(int i = 0 ; i < N + 1; i++) {
            arr.add(new ArrayList<Node>());
        }

        for(int i = 0; i < M; i++) {
            String[] ss = br.readLine().split(" ");
            int start = Integer.parseInt(ss[0]);
            int end = Integer.parseInt(ss[1]);
            int cost = Integer.parseInt(ss[2]);
            arr.get(start).add(new Node(end, cost));
        }

        home = findPath(X);

        for(int i = 1; i<= N; i++) {
            int[] dis = findPath(i);
            res.add(dis[X] + home[i]);
        }
        Collections.sort(res);
        System.out.println(res.get(res.size() - 1));
    }

    private static int[] findPath(int i) {
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(i, 0));
        dis[i] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if(curNode.cost > dis[curNode.end]) {
                continue;
            }

            for(int j = 0; j < arr.get(curNode.end).size(); j++) {
                Node nextNode = arr.get(curNode.end).get(j);
                if(nextNode.cost + curNode.cost < dis[nextNode.end]) {
                    dis[nextNode.end] = nextNode.cost + curNode.cost;
                    pq.offer(new Node(nextNode.end, dis[nextNode.end]));
                }
            }
        }
        return dis;
    }

    static class Node {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
