//package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<ArrayList<Integer>> arr;
    static int[] visited;
    static int[] res;
    static int N;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 1;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer i : arr.get(poll)) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    res[i] = poll;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        visited = new int[N + 1];
        res = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        bfs();
        for (int i = 2; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}