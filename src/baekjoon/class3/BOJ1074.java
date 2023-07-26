package baekjoon.class3;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1074 {
    static int N, r, c, idx;
    static int[][] board;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);

        board = new int[N][N];
        idx = 0;
        int len = (int)Math.pow(2, N);

        recursive(r, c, len);
        System.out.println(idx);
    }

    static void recursive(int x, int y, int len) {
        if(len == 1) {
            return;
        }
        // 1사분면
        if(x < len / 2 && y < len / 2) {
            recursive(x, y, len / 2);
        }
        // 2사분면
        else if(x < len / 2 && y >= len / 2) {
            idx += (len / 2) * (len / 2);
            recursive(x, y - len / 2, len / 2);
        }
        // 3사분면
        else if(x >= len / 2 && y < len / 2) {
            idx += 2 * (len / 2) * (len / 2);
            recursive(x - len / 2, y, len / 2);
        }
        // 4사분면
        else if(x >= len / 2 && y >= len / 2) {
            idx += 3 * (len / 2) * (len / 2);
            recursive(x - len / 2, y - len / 2, len / 2);
        }
    }
}
