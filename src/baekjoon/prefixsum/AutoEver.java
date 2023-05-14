package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AutoEver {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // 1 0 0 1 0 0 1 1
        // 1 4
        // 3 4
        // 6 8
        arr = new int[8];
        int N = 8;
        int[] prefix_sum = new int[N + 1];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i < N; i++) {
            prefix_sum[i + 1] = prefix_sum[i] + arr[i];
        }
        System.out.println(Arrays.toString(prefix_sum));
        System.out.println(prefix_sum[4] - prefix_sum[0]);
    }
}
