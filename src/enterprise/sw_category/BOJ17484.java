package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17484 {
    static int n, m;
    static int[][] board;
    static int[][][] dp;
    static int[] dx = {-1, 0, 1};
    static int res = (int)1e9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        board = new int[n][m];
        dp = new int[n][m][3];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
//        int res = (int)1e9;
        for(int i = 0; i < m; i++) {
            goToMoon(0, i, -1, 0);
        }

        System.out.println(res);
    }
    static void goToMoon(int r, int c, int dir, int sum) {
        if(r == n) {
            res = Math.min(res, sum);
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(dir == i) continue;
            int nx = c + dx[i];
            if(nx >= 0 && nx < m) {
                goToMoon(r + 1, nx, i, sum + board[r][c]);
            }
        }
    }
}
