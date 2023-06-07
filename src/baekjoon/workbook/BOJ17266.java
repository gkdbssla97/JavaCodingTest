package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17266 {
    static int N, M;
    static int[] board;
    static boolean[] road;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        road = new boolean[N + 1];
        board = new int[M];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            board[i] = Integer.parseInt(s[i]);
        }
        res = 1;
        binarySearch(1, N);
    }

    static void binarySearch(int low, int high) {
        while (low <= high) {
//            System.out.println("loop");
            int mid = (low + high) / 2;

            int point = 0;
            for (int k = 0; k < board.length; k++) {
                if (board[k] - mid <= point) {
                    point = board[k] + mid;
//                    System.out.println("point: " + point);
                }
            }
            if (N - point <= 0) {
//                System.out.println("mid; " + mid);
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(res);
    }

    /**
     * f f f f f f
     * o o x x o x
     * 5
     * 3
     * 0 1 4
     */
}