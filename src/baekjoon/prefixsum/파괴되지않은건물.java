package baekjoon.prefixsum;

import programmers.kakao.카카오채용연계형인턴십2021.표편집_answer;

public class 파괴되지않은건물 {
    static int[][] prefix;
    static int[][] prefix_res;
    public static int solution(int[][] board, int[][] skills) {
        int row = board.length;
        int col = board[0].length;

        prefix = new int[row + 1][col + 1];
        prefix_res = new int[row + 1][col + 1];

        for(int[] skill : skills) {
            int type = skill[0]; // 1-> 공격 2-> 회복
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];

            if (type == 2) {
                prefix[r1][c1] += degree;
                prefix[r1][c2 + 1] += (-degree);
                prefix[r2 + 1][c1] += (-degree);
                prefix[r2 + 1][c2 + 1] += degree;
            } else {
                prefix[r1][c1] += (-degree);
                prefix[r1][c2 + 1] += degree;
                prefix[r2 + 1][c1] += degree;
                prefix[r2 + 1][c2 + 1] += (-degree);
            }
        }

        for(int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                prefix_res[i][j] = prefix[i - 1][j - 1] + prefix_res[i - 1][j] + prefix_res[i][j - 1] - prefix_res[i - 1][j - 1];
            }
        }
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(prefix_res[i + 1][j + 1] + board[i][j] > 0) {
                    answer++;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(solution(board, skill));
    }
}
