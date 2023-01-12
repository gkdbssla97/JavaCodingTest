package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ11403 {
    static int N, des_x, des_y;
    static int[][] board;
    static int[][] res;
    static boolean[][] visited;
    static boolean isArrived;
    static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        res = new int[N][N];
        for (int i = 0; i < N; i++) {
            List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int j = 0; j < N; j++) {
                board[i][j] = collect.get(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    res[i][j] = board[i][j];
                else if (board[i][j] == 0)
                    res[i][j] = INF;
            }
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == 3 && j == 1 && res[i][j] > 0)
                        System.out.println("now!1 -> " + i + " " + j + " " + k);
                    if (i == 3 && j == 0 && res[i][j] > 0)
                        System.out.println("now!2 -> " + i + " " + j + " " + k);
                    res[i][j] = Math.min(res[i][j], res[i][k] + res[k][j]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(res[i][j] == INF) res[i][j] = 0;
                else if(res[i][j] > 0) res[i][j] = 1;
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}