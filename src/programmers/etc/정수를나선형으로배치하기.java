package programmers.etc;

import java.util.Arrays;

class 정수를나선형으로배치하기 {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dy = {1, 0, -1, 0};
    static int cnt = 0;
    public static void main(String[] args) {
        solution(9);
    }
    public static int[][] solution(int n) {
        board = new int[n][n];
        visited = new boolean[n][n];
        int x = 0;
        int y = 0;
        int val = 1;
        while(cnt < n * n) {
            // 1 동
            while(true) {
                if(0 <= x && x < n && 0 <= y && y < n && !visited[x][y]) {
                    board[x][y] = val++;
                    visited[x][y] = true;
                    y++;
                    cnt++;
                } else {
                    y--;
                    x++;
                    break;
                }
            }
//            System.out.println("x, y: " + x + " " + y);
            // 2 남
            while(true) {
                if(0 <= x && x < n && 0 <= y && y < n && !visited[x][y]) {
                    board[x][y] = val++;
                    visited[x][y] = true;
                    x++;
                    cnt++;
                } else {
                    x--;
                    y--;
                    break;
                }
            }
            System.out.println("x, y: " + x + " " + y);
            // 3 서
            while(true) {
                if(0 <= x && x < n && 0 <= y && y < n && !visited[x][y]) {
                    board[x][y] = val++;
                    visited[x][y] = true;
                    y--;
                    cnt++;
                } else {
                    y++;
                    x--;
                    break;
                }
            }
            System.out.println("x, y: " + x + " " + y);
            // 4 북
            while(true) {
                if(0 <= x && x < n && 0 <= y && y < n && !visited[x][y]) {
                    board[x][y] = val++;
                    visited[x][y] = true;
                    x--;
                    cnt++;
                } else {
                    x++;
                    y++;
                    break;
                }
            }
//            if(cnt == 10) {
//                break;
//            }
            System.out.println("x, y: " + x + " " + y);
        }
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        int[][] answer = {};
        return board;
    }
}