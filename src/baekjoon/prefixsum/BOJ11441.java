package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ11441 {
    static int N, M;
    static int[] arr;
    static int[] prefix_sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        arr = new int[N];
        prefix_sum = new int[N + 1];
        for(int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            prefix_sum[i + 1] = prefix_sum[i] + arr[i];
        }
//        System.out.println(Arrays.toString(prefix_sum));
        for(int i = 0; i < M; i++) {
            String[] ss = br.readLine().split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            System.out.println(prefix_sum[b] - prefix_sum[a - 1]);
        }
    }
}
