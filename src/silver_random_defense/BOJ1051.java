package silver_random_defense;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1051 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] board = new int[n][m];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        int max = 0;
        for(int l = 1; l < Math.min(n, m); l++) {

            for(int i = 0; i < n - l; i++) {
                for(int j = 0; j < m - l; j++) {
                    int lt = board[i][j]; // 좌측상단
                    int rt = board[i][j + l];// 우측상단
                    int lb = board[i + l][j];// 좌측하단
                    int rb = board[i + l][j + l];// 우측하단
                    if(lt == rt && rt == lb
                    && lt == lb && rt == rb) {
                        max = Math.max(max, l);
                    }
                }
            }
        }
        System.out.println((max + 1) * (max + 1));
    }
}
