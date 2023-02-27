package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17390 {
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        board = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(board);
        for (int i = 1; i <= N; i++) {
            board[i] += board[i - 1];
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int ans = board[R] - board[L - 1];
            System.out.println(ans);
        }
    }
}
