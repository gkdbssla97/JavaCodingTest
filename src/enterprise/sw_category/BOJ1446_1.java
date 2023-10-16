package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ1446_1 {
    static int res = 10001;
    static ArrayList<ArrayList<Node>> node;
    static boolean[] visited;
    static int[] distance;
    static int d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        d = Integer.parseInt(s[1]);
        node = new ArrayList<>();
        visited = new boolean[n];
        distance = new int[10001];
        Arrays.fill(distance, 10001);
        distance[0] = 0;
        for(int i = 0; i <= 10001; i++) {
            node.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            if(end - start <= cost) continue;
            node.get(start).add(new Node(end, cost));
        }
        for(int i = 0; i <= d; i++) {
            if(i != 0) {
                distance[i] = Math.min(distance[i - 1] + 1, distance[i]);
            }
            if(node.get(i).size() > 0) {
                for(Node node : node.get(i)) {
                    if(distance[node.end] > distance[i] + node.cost) {
                        distance[node.end] = distance[i] + node.cost;
                    }
                }
            }
        }
        System.out.println(distance[d]);
    }
    static class Node {
        int end, cost;

        Node(int end, int cost) {

            this.end = end;
            this.cost = cost;
        }
    }
}
