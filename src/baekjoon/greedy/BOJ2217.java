package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            board[i] = val;
        }
        Arrays.sort(board);
        int max = 0;
        int sum = 0;
        int cnt = 1;
        for (int i = n - 1; i >= 0; i--) {
            sum = board[i] * cnt++;
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
