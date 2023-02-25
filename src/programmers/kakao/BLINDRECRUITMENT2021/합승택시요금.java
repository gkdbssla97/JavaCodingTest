package programmers.kakao.BLINDRECRUITMENT2021;

import java.util.Arrays;

public class 합승택시요금 {
    static int[][] board;
    static boolean[] visited;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        board = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(board[i], 200 * 100000 + 1);
            board[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            board[fares[i][0]][fares[i][1]] = fares[i][2];
            board[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = Math.min(board[i][k] + board[k][j], board[i][j]);
                }
            }
        }
        // 각각 집에 가는 경우
        answer = board[s][a] + board[s][b];
        // 합승 택시
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, board[s][i] + board[i][a] + board[i][b]);
        }

//        for(int i = 0; i < n; i++) {
//            System.out.print(Arrays.toString(board[i]) + " ");
//            System.out.println();
//        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66},
                {2, 3, 22}, {1, 6, 25}};
        solution(n, s, a, b, fares);

    }
}
