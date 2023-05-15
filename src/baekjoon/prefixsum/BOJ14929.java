package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] prefix = new int[n + 1];
        for(int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
            prefix[i + 1] = arr[i] + prefix[i];
        }
        // 0 1 -1 2
        long total = 0 ;
        for (int i = 1; i <= n; i++) {
            total = total + ((long) arr[i - 1] * (prefix[n] - prefix[i]));
        }
        System.out.println(total);
    }
}
