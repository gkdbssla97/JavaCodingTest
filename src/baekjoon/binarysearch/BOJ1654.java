package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ1654 {
    static int K, N;
    static int[] arr;
    static PriorityQueue<Integer> p;
    static long res_max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        K = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        arr = new int[K];
        p = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            String s1 = br.readLine();
            arr[i] = Integer.parseInt(s1);
        }
        long min_value = 0;
        for (int i = 0; i < K; i++) {
            if (min_value <= arr[i]) {
                min_value = arr[i];
            }
        }
        if (min_value % 2 != 0) {
            min_value -= 1;
        }
        binarySearch(N, 1, min_value + 1);
        System.out.println(res_max);

    }

    static long binarySearch(long key, long low, long high) {
        long mid;
        if (low <= high) {
            mid = (low + high) / 2;
            long tmp = check_lan(N, mid, arr);
            if (res_max <= tmp) {
                res_max = tmp;
            }
            if (tmp == -1) {
                return binarySearch(key, low, mid - 1);
            } else
                return binarySearch(key, mid + 1, high);
        }
        return -1;
    }

    static long check_lan(long N, long mid, int[] arr) {
        long cnt = 0;
        for (long a : arr) {
            cnt = cnt + (a / mid);
        }
        if (cnt >= N) {
            return mid;
        }
        return -1;
    }
}
