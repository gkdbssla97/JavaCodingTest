package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11404 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) board[i][j] = 0;
                else board[i][j] = (int)1e9;
            }
        }
        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if(board[a][b] >= 1) board[a][b] = Math.min(board[a][b], c);
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    board[i][j] = Math.min(board[i][j],
                            board[i][k] + board[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(board[i][j] == (int)1e9) board[i][j] = 0;
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
