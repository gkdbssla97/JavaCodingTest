package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9466 {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(input[j - 1]);
            }

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }

            sb.append((n - count) + "\n");
            System.out.println(Arrays.toString(finished));
        }

        System.out.print(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;
        int next = arr[node];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            countCycleLength(next);
        }

        finished[node] = true;
    }

    private static void countCycleLength(int startNode) {
        int currentNode = startNode;

        while (true) {
            count++;
            currentNode = arr[currentNode];
            if (currentNode == startNode) {
                break;
            }
        }
    }
}
