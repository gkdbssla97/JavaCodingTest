package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ15663 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb;
    static Set<String> set = new LinkedHashSet<>();
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
        List<String> collect = new ArrayList<>(set);
//        System.out.println(collect);
        sb = new StringBuilder();
        for(String str : collect) {
            sb.append(str);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int depth, int start) {
        if(depth == M) {
//            for(int i = 0; i < selected.length - 1; i++) {
//                if(selected[i] > selected[i + 1]) {
//                    return;
//                }
//            }
            sb = new StringBuilder();
            for(int i : selected) {
                sb.append(i);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[start] = arr[i];
                dfs(depth + 1, start + 1);
                visited[i] = false;
            }
        }
    }
}
