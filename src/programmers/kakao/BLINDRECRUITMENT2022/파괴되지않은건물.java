package programmers.kakao.BLINDRECRUITMENT2022;

import java.util.ArrayList;


public class 파괴되지않은건물 {
    public static int solution(int[][] board, int[][] skills) {
        int answer = 0;

        int r = board.length;
        int c = board[0].length;

        int[][] preSum = new int[r + 1][c + 1];

        for (int[] skill : skills) {
            int type = skill[0];
            int x1 = skill[1];
            int y1 = skill[2];
            int x2 = skill[3];
            int y2 = skill[4];
            int dmg = skill[5];

            if (type == 2) {
                preSum[x1][y1] += dmg;
                preSum[x2 + 1][y2 + 1] += dmg;
                preSum[x1][y2 + 1] += -dmg;
                preSum[x2 + 1][y1] += -dmg;
            } else {
                preSum[x1][y1] += -dmg;
                preSum[x2+ 1][y2 + 1] += -dmg;
                preSum[x1][y2 + 1] += dmg;
                preSum[x2 + 1][y1] += dmg;
            }
        }
            /* 가로 누적합 계산 */
            for (int i = 0; i < r + 1; i++) {
                int sum = 0;
                for (int j = 0; j < c + 1; j++) {
                    sum += preSum[i][j];
                    preSum[i][j] = sum;
                }
            }
            /* 세로 누적합 계산 */
            for (int i = 0; i < c; i++) {
                int sum = 0;
                for (int j = 0; j < r; j++) {
                    sum += preSum[j][i];
                    preSum[j][i] = sum;
                }
            }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] + preSum[i][j]> 0)
                    answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        System.out.println(solution(board, skill));
    }
}
