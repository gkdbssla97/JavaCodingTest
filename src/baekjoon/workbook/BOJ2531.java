package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ2531 {
    static int N, d, k, c;
    static int[] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        d = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        c = Integer.parseInt(s[3]);

        board = new int[N + k];
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }
        for(int i = N; i < N + k; i++) {
            board[i] = board[i - N];
        }
//        System.out.println(Arrays.toString(board));
        /**
         * 7 9 7 30 2 7 9 25
         */
        int res = 0;
        HashSet<Integer> hashSet;
        for (int i = 0; i < board.length - k; i++) {
            hashSet = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                hashSet.add(board[j]);
            }
            hashSet.add(c);
            if (res < hashSet.size()) {
                res = hashSet.size();
            }
        }
        System.out.println(res);
    }
}
