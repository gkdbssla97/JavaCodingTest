package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int[][] board;
    static boolean[][] visited;
    static int N, M, r, c, d;
    static int[] dx = {-1, 0, 1, 0}; // 북 서 남 동
    static int[] dy = {0, 11, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] s1 = br.readLine().split(" ");
        r = Integer.parseInt(s1[0]);
        c = Integer.parseInt(s1[1]);
        d = Integer.parseInt(s1[2]); // 0북 1동 2남 3서

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(r, c, d);
        System.out.println(cnt);
    }

    static void bfs(int x, int y, int d) {
        board[x][y] = 2;
        cnt++;

        for (int i = 0; i < 4; i++) {
            d -= 1;
            if (d == -1) d = 3;
            int nx = dx[d] + x;
            int ny = dy[d] + y;
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (board[nx][ny] == 0) {
                    cnt++;
                    bfs(nx, ny, d);
                    return;
                }
            }
        }

        int dir = (d + 2) % 4;
        int bx = dx[dir] + x;
        int by = dy[dir] + x;
        if(bx >= 0 && bx < N && by >= 0 && by < M && board[bx][by] != 1){
            bfs(bx, by, dir);
        }
    }


    static class Point {
        int x, y, val;

        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
