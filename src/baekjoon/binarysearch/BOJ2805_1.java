package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2805_1 {
    static long N, M;
    static long[] tree;
    static long res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Long.parseLong(s[0]);
        M = Long.parseLong(s[1]);
        tree = new long[(int) N];
        String[] ss = br.readLine().split(" ");
        long max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(ss[i]);
            if(max < tree[i]) {
                max = tree[i];
            }
        }
        binarySearch(0, max);
        System.out.println(res);
    }
    static void binarySearch(long low, long high) {
        if(low <= high) {
            long mid = (low + high) / 2;
//            System.out.println("mid: " + mid);
            long sum = 0;
            for(long t : tree) {
//                System.out.println("t:mid -> " + t + " " + mid);
                if(t - mid >= 0) {
                    sum = sum + t - mid;
                }
//                System.out.println("sum-> " + sum);
            }
//            System.out.println("sum: " + sum);
            if(sum >= M) {
                if(res <= mid) {
                    res = mid;
                }
                binarySearch(mid + 1, high);
            } else {
                binarySearch(0, mid - 1);
            }
        }
    }
}
