package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ11725 {
    static int N;
    static ArrayList<ArrayList<Integer>> board;
    static boolean[] visited;
    static Integer[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new ArrayList<>(N + 1);
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            board.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            board.get(collect.get(0)).add(collect.get(1));
            board.get(collect.get(1)).add(collect.get(0));
        }
        list = new Integer[N + 1];
        bfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(list[i]);
        }
    }
    static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer num : board.get(poll)) {
                if (!visited[num]) {
                    visited[num] = true;
                    list[num] = poll;
                    q.offer(num);
                }
            }
        }
    }
}
