package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ1167 {
    static int N;
    static ArrayList<ArrayList<Node>> board;
    static boolean[] visited;
    static int res;
    static int far_node;
    static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; i++) {
            board.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int j = 1; j < collect.size() - 2; j += 2) {
                board.get(collect.get(0)).add(new Node(collect.get(j), collect.get(j + 1)));
                board.get(collect.get(j)).add(new Node(collect.get(0), collect.get(j + 1)));
            }
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N + 1];
        visited[far_node] = true;
        dfs(far_node, 0);

        System.out.println(res);
    }

    static void dfs(int i, int sum) {
        if (res < sum) {
            far_node = i;
            res = sum;
        }
        for (Node n : board.get(i)) {
            if (!visited[n.num]) {
                visited[n.num] = true;
                dfs(n.num, sum + n.weight);
            }
        }
    }
}
