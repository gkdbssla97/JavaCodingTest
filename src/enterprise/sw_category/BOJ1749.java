package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1749 {
    static int n, m;
    static int[][] board, prefix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        board = new int[n + 1][m + 1];
        prefix = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                board[i + 1][j + 1] = Integer.parseInt(s[j]);
            }
        }

        // 누적합
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                prefix[i][j] = board[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        long res = Integer.MIN_VALUE;
        for(int sx = 1; sx <= n; sx++) {
            for(int sy = 1; sy <= m; sy++) {
                for (int ex = sx; ex <= n; ex++) {
                    for (int ey = sy; ey <= m; ey++) {
                        res = Math.max(res, getSum(ex, ey, sx, sy));
                    }
                }
            }
        }
        System.out.println(res);
    }

    static long getSum(int ex, int ey, int sx, int sy) {
        return prefix[ex][ey] - prefix[sx - 1][ey] - prefix[ex][sy - 1] + prefix[sx - 1][sy - 1];
    }

}
