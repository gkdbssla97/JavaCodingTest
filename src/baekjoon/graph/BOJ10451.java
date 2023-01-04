package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ10451 {

    static int[][] board;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int cnt = 0;
            N = Integer.parseInt(br.readLine());
            board = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            List<String> collect = Arrays.stream(br.readLine().split(" "))
                    .collect(Collectors.toList());
            List<Integer> array = collect.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int j = 0; j < N; j++) {
                board[j + 1][array.get(j)] = 1;
                board[array.get(j)][j + 1] = 1;
            }
            for (int k = 1; k <= N; k++) {
                if (!visited[k]) {
                    dfs(k);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int i) {
        visited[i] = true;
        for (int x = 1; x <= N; x++) {
            if (!visited[x] && board[i][x] == 1) {
                visited[x] = true;
                dfs(x);
            }
        }
    }
}
