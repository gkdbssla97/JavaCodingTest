package programmers.etc;

import java.util.*;
import java.io.*;

public class 행렬테두리회전하기 {
    static int[][] board;
    static int rows;
    static int columns;
    static ArrayList<Integer> first_arr;

    public static int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows][columns];
        init(board);

//        print(board);
        ArrayList<Integer> res;
        int min;
        int[] answer = new int[queries.length];
        int idx_r = 0;
        for (int[] a : queries) {
            int idx = 0;
            res = new ArrayList<>();
            first_arr = new ArrayList<>();
            for (int i = a[1] - 1; i <= a[3] - 1; i++) {
                first_arr.add(board[a[0] - 1][i]);
            }
//            System.out.println(first_arr);
            // 4 (2,2) (5,4)
            // 4 (3,3) (6,6)
//            System.out.println("4");
            for (int i = a[0]; i <= a[2] - 1; i++) {
                board[i - 1][a[1] - 1] = board[i][a[1] - 1];
                res.add(board[i - 1][a[1] - 1]);
            }
//            System.out.println("3");
            // 3 (2,2) (5,4)
            for (int i = a[1]; i <= a[3] - 1; i++) {
                board[a[2] - 1][i - 1] = board[a[2] - 1][i];
                res.add(board[a[2] - 1][i - 1]);
            }
//            System.out.println("2");
            // 2 (2,2) (5,4)
            // 2 (3,3) (6,6)
            for (int i = a[2] - 1; i >= a[0]; i--) {
                board[i][a[3] - 1] = board[i - 1][a[3] - 1];
                res.add(board[i][a[3] - 1]);
            }
//            System.out.println("1");
            // 1 (2,2) (5,4)
            for (int i = a[1]; i <= a[3] - 1; i++) {
                board[a[0] - 1][i] = first_arr.get(idx++);
                res.add(board[a[0] - 1][i]);
            }
//            print(board);
//            System.out.println("---");
            answer[idx_r++] = Collections.min(res);
        }


        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) throws IOException {

        rows = 6;
        columns = 6;

        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }

    static void init(int[][] board) {
        int val = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = val++;
            }
        }
    }

    static void print(int[][] board) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
