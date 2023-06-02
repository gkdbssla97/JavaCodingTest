package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1205 {
    static int N, M, P;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        P = Integer.parseInt(s[2]);

        arr = new int[P];
        if(N != 0) {
            String[] ss = br.readLine().split(" ");
            for (int i = 0; i < ss.length; i++) {
                arr[i] = Integer.parseInt(ss[i]);
            }
            int rank = 1;
            int cnt = 1;
            boolean flag = false;
            for (int i = 0; i < P; i++) {
                if (arr[i] > M) {
                    rank++;
                    flag = true;
                } else if (arr[i] < M) {
                    break;
                }
                cnt++;
            }
            if (N == P && M <= arr[N - 1]) {
                System.out.println(-1);
            } else {
                System.out.println(rank);
            }
        } else {
            System.out.println(1);
        }
    }
}
