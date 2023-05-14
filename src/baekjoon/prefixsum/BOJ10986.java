package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10986 {
    static int N, M;
    static int[] arr;
    static long[] prefix;
    static long[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N];
        prefix = new long[N + 1];
        cnt = new long[M];
        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }

        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
            long i1 = prefix[i + 1] % M;
            cnt[(int) i1]++;
        }
        long result = 0;
        for(int i = 0; i < M; i++) {
            result += (cnt[i] * (cnt[i] - 1)) / 2;
        }
        result += cnt[0];
//        System.out.println(Arrays.toString(prefix));
//        System.out.println(Arrays.toString(cnt));
        System.out.println(result);
    }
}
