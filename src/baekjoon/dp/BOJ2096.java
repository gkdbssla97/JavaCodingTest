package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2096 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][3];
        int[][] maxDp = new int[n + 1][3];
        int[][] minDp = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
            for (int j = 0; j < 3; j++) {
                board[i + 1][j] = Integer.parseInt(s[j]);
            }
        }
        minDp[0][0] = 0;
        minDp[0][1] = 0;
        minDp[0][2] = 0;
        // 최대
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                // 왼쪽
                if(j == 0){
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]) + board[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]) + board[i][j];
                }
                // 오른쪽
                else if(j == 2) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j - 1]) + board[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j - 1]) + board[i][j];
                }
                // 가운데
                else {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]) + board[i][j];
                    maxDp[i][j] = Math.max(maxDp[i - 1][j - 1] + board[i][j], maxDp[i][j]);

                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]) + board[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j - 1] + board[i][j], minDp[i][j]);
                }
            }
        }
        System.out.print(Arrays.stream(maxDp[n]).max().getAsInt()+ " ");
        System.out.println(Arrays.stream(minDp[n]).min().getAsInt());
    }
}
