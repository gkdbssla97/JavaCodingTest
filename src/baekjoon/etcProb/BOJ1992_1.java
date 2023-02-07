package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992_1 {
    static int[][] board;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        checkSquare(0, 0, N);
    }

    static void checkSquare(int x, int y, int M) {
        if (isPossible(x, y, M)) {
            sb.append(board[x][y]);
            return;
        }

        int newSize = M / 2;
        sb.append("(");
        checkSquare(x, y, newSize);
        checkSquare(x, y + newSize, newSize);
        checkSquare(x + newSize, y, newSize);
        checkSquare(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    static boolean isPossible(int x, int y, int M) {
        int value = board[x][y];
        for (int i = x; i < x + M; i++) {
            for (int j = y; j < y + M; j++) {
                if(value != board[x][y])
                    return false;
            }
        } return true;
    }
}
