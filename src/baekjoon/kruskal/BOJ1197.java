package baekjoon.kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1197 {
    static ArrayList<Node> arr = new ArrayList<>();
    static int[] parent;
    static int res_cost = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);


        parent = new int[v + 1];
        for(int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            arr.add(new Node(start, end, cost));
        }

        Collections.sort(arr, (o1, o2) -> Integer.compare(o1.cost, o2.cost));

        for(int i = 0; i < e; i++) {
            if(find(arr.get(i).start) != find(arr.get(i).end)) {
                union(arr.get(i).start, arr.get(i).end);
                res_cost += arr.get(i).cost;
            }
        }

        System.out.println(res_cost);
    }

    static int find(int a) {
        if(parent[a] == a) {
            return parent[a];
        } return find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static class Node {
        int start, end, cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
