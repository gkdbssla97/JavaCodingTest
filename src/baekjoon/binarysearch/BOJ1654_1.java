package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1654_1 {
    static int N;
    static long K;
    static long[] lan;
    static long res_max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        K = Long.parseLong(s[0]);
        N = Integer.parseInt(s[1]);

        lan = new long[(int) K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            lan[i] = Long.parseLong(br.readLine());
            if (max <= lan[i]) {
                max = lan[i];
            }
        }
        binarySearch(0, 1, max);
        System.out.println(res_max);
    }
    static int binarySearch(long cnt, long low, long high) {
        if(low <= high) {
            long mid = (low + high) / 2;
            for(long l : lan) {
                cnt += (l / mid);
            }
            if(cnt >= N) {
                if(res_max <= mid) {
                    res_max = mid;
                }
                binarySearch(0, mid + 1, high);
            } else {
                binarySearch(0, 1, mid - 1);
            }
        }
        return -1;
    }
}
