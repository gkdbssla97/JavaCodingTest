package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1783 {
    static int N, M;
    static int[] dx = {-2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1};
    static int[][] board;
    static boolean[][] visited;
    static boolean[] checkDirection;
    static int res = 1;

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            if (M <= 2) {
                System.out.println(1);
            } else {
                System.out.println(Math.min((M + 1) / 2, 4));
            }
        } else if (N >= 3) {
            if (M < 7) {
                System.out.println(Math.min(M, 4));
            } else {
                System.out.println(M - 2);
            }
        }
    }
}
