package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ1967_1 {
    static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
    static int N;
    static int res;
    static ArrayList<ArrayList<Node>> board;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            board.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            board.get(collect.get(0)).add(new Node(collect.get(1), collect.get(2)));
            board.get(collect.get(1)).add(new Node(collect.get(0), collect.get(2)));
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, 0);
        }
        System.out.println(res);
    }
    static void dfs(int i, int sum) {
        visited[i] = true;
        if (res < sum) {
            res = sum;
        }
        for (Node n : board.get(i)) {
            if(!visited[n.num]) {
                visited[n.num] = true;
                dfs(n.num, sum + n.weight);
            }
        }
    }

}
