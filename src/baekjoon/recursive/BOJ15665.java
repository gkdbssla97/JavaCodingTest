package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15665 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb;
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N];
        selected = new int[M];
        String[] ss = br.readLine().split(" ");
        for(int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(arr);
        dfs(0);
        List<String> list = new ArrayList<>(set);
        sb = new StringBuilder();
        for(String str : list) {
            sb.append(str);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int start) {
        if(start == M) {
//            System.out.println(Arrays.toString(selected));
            for(int i = 0; i < selected.length - 1; i++) {
                if(selected[i] > selected[i + 1]) {
                    return;
                }
            }
            sb = new StringBuilder();
            for(int i : selected) {
                sb.append(i);
                sb.append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i < N; i++) {
            selected[start] = arr[i];
            dfs(start + 1);
        }
    }
}
