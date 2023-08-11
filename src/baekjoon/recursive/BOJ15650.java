package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ15650 {
    static int[] selected;
    static boolean[] visited;
    static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        selected = new int[M];
        m = M;
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        visited = new boolean[N];
        dfs(arr, 0, 0);
    }
    static void dfs(int[] arr, int depth, int start) {
        if(depth == m) {
            System.out.println(Arrays.toString(selected));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[depth] = arr[i];
                dfs(arr, depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
