package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15651 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];
        selected = new int[M];
        dfs(0);
        System.out.println(sb);
    }
    static void dfs(int start) {
        if(start == M) {
            for (int i : selected) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            selected[start] = i + 1;
            dfs(start + 1);
        }
    }
}
