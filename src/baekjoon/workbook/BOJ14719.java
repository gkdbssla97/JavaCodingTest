package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14719 {
    static int H, W;
    static int[][] board;
    static boolean[][] visited;
    static int[] rain;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        H = Integer.parseInt(s[0]);
        W = Integer.parseInt(s[1]);

        rain = new int[W];
        board = new int[H][W];
        visited = new boolean[H][W];

        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < ss.length; i++) {
            rain[i] = Integer.parseInt(ss[i]);
        }

        for(int i = 1; i < W - 1; i++) {
            int current = rain[i];
            int leftMax = rain[i];
            int rightMax = rain[i];
            for(int j = i - 1; j >= 0; j--) {
                if(rain[j] > current) {
                    leftMax = Math.max(leftMax, rain[j]);
                }
            }
            for(int j = i + 1; j < W; j++) {
                if(rain[j] > current) {
                    rightMax = Math.max(rightMax, rain[j]);
                }
            }
            int val = Math.min(leftMax, rightMax);
            res += val - current;
        }
        System.out.println(res);
//        for (int i = 0; i < H; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
    }

    static void stackRain(int col, int num) {
        int tmp = H;
        for (int i = 0; i < num; i++) {
            board[tmp - 1][col] = 1;
            tmp--;
        }
    }
}
