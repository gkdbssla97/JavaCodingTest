package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ15649 {
    static int[] selected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        selected = new int[M];
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        boolean[] visited = new boolean[N];
        permutation(arr, visited, 0, M);
    }
    static void permutation(int[] arr, boolean[] visited, int start, int M) {
        if(start == M) {
            List<String> collect = Arrays.stream(selected).boxed().map(String::valueOf).collect(Collectors.toList());
            System.out.println(String.join(" ", collect));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[start] = arr[i];
                permutation(arr, visited, start + 1, M);
                visited[i] = false;
            }
        }
    }
}
