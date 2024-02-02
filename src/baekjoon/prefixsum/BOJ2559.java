package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] board = new int[n + 1];
        for (int i = 0; i < n; i++) {
            board[i + 1] = Integer.parseInt(s[i]);
        }

        int[] prefix = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            prefix[i] = board[i] + prefix[i - 1];
        }
        int max = Integer.MIN_VALUE;
        for(int i = k; i <= n; i++) {
            int sum = prefix[i] - prefix[i - k];
            max = Math.max(max, sum);
        }
        System.out.println(max);
//        System.out.println(Arrays.toString(prefix));
    }
}
