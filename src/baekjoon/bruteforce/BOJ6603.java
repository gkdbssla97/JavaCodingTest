package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ6603 {
    static List<Integer> collect;
    static int[] board;
    static int[] res;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            collect = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            board = new int[collect.get(0)];
            for (int i = 0; i < board.length; i++) {
                board[i] = collect.get(i + 1);
            }
            res = new int[6];
            visited = new boolean[board.length];
            combination_DFS(0, board.length, 6);
            System.out.println();
        } while (collect.get(0) != 0);
    }

    static void combination_DFS(int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    System.out.print(board[i] + " ");
            }
            System.out.println();
            return;
        }
        if (start == n)
            return;
        visited[start] = true;
        combination_DFS(start + 1, n, r - 1);
        visited[start] = false;
        combination_DFS(start + 1, n, r);
    }
}
