package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2805 {
    static int N, M;
    static int[] arr;
    static long max_val = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N];
        String[] ss = br.readLine().split(" ");
        long max = 0;
        for(int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
            if(max <= arr[i]) {
                max = arr[i];
            }
        }

        binarySearch(1, max);
        System.out.println(max_val);
    }
    static int binarySearch(long low, long high) {
        long mid;

        if(low <= high) {
            mid = (low + high) / 2;
            long tmp = check_tree(mid, arr);
            if(tmp >= M) {
                if(max_val <= mid) {
                    max_val = mid;
                } return binarySearch(mid + 1, high);
            }
            return binarySearch(low, mid - 1);
        }
        return -1;
    }
    static long check_tree(long mid, int[] arr) {
        long total = 0;
        for(int a : arr) {
            long tmp = a - mid;
            if(tmp >= 0) {
                total += tmp;
            }
        }
        return total;
    }
}
