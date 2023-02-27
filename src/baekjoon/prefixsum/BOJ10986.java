package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10986 {
    static long[] A;
    static long[] mod;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new long[N + 1];
        mod = new long[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;
        //누적합
        for (int i = 1; i <= N; i++) {
            A[i] += A[i-1];
        }
        for (int i = 1; i <= N; i++) {
            A[i] %= M;
            if(A[i] == 0) cnt++;
            ++mod[(int)A[i]];
        }
        for (int i = 0; i < mod.length; i++) {
            if (mod[i] > 1) {
                cnt += (mod[i] * (mod[i] - 1)) / 2;
            }
        }
        System.out.println(cnt);
    }
}
