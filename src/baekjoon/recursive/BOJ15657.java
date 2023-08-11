package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15657 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        String[] ss = br.readLine().split(" ");
        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        selected = new int[M];
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }
    static void dfs(int depth, int start) {
        if(start == M) {
            for(int i = 0; i < selected.length - 1; i++) {
                if(selected[i] > selected[i + 1]) {
                    return;
                }
            }
            for(int i : selected) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            selected[start] = arr[i];
            dfs(depth + 1, start + 1);
        }
    }
}
