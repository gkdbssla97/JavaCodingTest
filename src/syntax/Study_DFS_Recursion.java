package syntax;

import java.util.Arrays;

public class Study_DFS_Recursion {
    static boolean[] visited = new boolean[9];
    static int[][] graph = {{}, {2,3,8}, {1,6,8},
            {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args) {
        for (boolean b : visited) {
            System.out.println(b);
        }
        dfs(1);
    }

    static void dfs(int nodeIdx) {
        visited[nodeIdx] = true;
        System.out.println(nodeIdx + "->");

        for (int node : graph[nodeIdx]) {
            if (!visited[node]) {
                dfs(node);
            }
        }

    }
}
