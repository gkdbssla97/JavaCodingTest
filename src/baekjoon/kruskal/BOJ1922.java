package baekjoon.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class BOJ1922 {
    static int n, m;
    static ArrayList<Node> arr = new ArrayList<>();
    static int[] parent;
    static int[] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for(int i = 0; i <=n; i++) parent[i] = i;
        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            arr.add(new Node(start, end, cost));
        }

        Collections.sort(arr, (o1, o2) -> Integer.compare(o1.cost, o2.cost));
        int res = 0;
        for(int i = 0; i < m; i++) {
            if(find(arr.get(i).start) != find(arr.get(i).end)) {
                union(arr.get(i).start, arr.get(i).end);
                res += arr.get(i).cost;
            }
        }
        System.out.println(res);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a <= b) parent[b] = a;
        else parent[a] = b;
    }
    static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
    static class Node {
        int start, end, cost;

        Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
