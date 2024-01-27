package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9663 {
    static int[] selected;
    static int[] visited;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new int[n];
        dfs(0);
//        System.out.println(Arrays.toString(visited));
        System.out.println(cnt);
    }

    static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        for(int j = 0; j < n; j++) {
            visited[depth] = j;
            if(isPossible(depth))
                dfs(depth + 1);
        }
    }
    static boolean isPossible(int depth) {
        for(int i = 0; i < depth; i++) {
            if(visited[depth] == visited[i]) {
                return false;
            }
            else if(Math.abs(depth - i) == Math.abs(visited[depth] - visited[i])) {
                return false;
            }
        }

        return true;
    }
}
