package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1780_1 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int MINUS, ZERO, ONE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        partition(0, 0, N);
        System.out.println(MINUS);
        System.out.println(ZERO);
        System.out.println(ONE);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
    }
    static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)) {
            if (board[row][col] == 0) {
                ZERO++;
            } else if (board[row][col] == -1) {
                MINUS++;
            } else if (board[row][col] == 1) {
                ONE++;
            }
            return;
        }
        // 9등분 좌측상단 -> 우측 상단 -> 순으로 우측 하단까지 1, 2.. 8, 9 로 가정
        int newSize = size / 3;
        partition(row, col, newSize); // 1
        partition(row, col + newSize, newSize); // 2
        partition(row, col + 2 * newSize, newSize); // 3

        partition(row + newSize, col, newSize); // 4
        partition(row + newSize, col + newSize, newSize); // 5
        partition(row + newSize, col + 2 * newSize, newSize); // 6

        partition(row + 2 * newSize, col, newSize); // 7
        partition(row + 2 * newSize, col + newSize, newSize); // 8
        partition(row + 2 * newSize, col + 2 * newSize, newSize); // 9

    }
    static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
