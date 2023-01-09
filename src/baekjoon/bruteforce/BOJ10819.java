package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ10819 {
    static int T;
    static boolean[] visited;
    static List<Integer> collect;
    static int[] board;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        collect = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        res = Integer.MIN_VALUE;
        for (int j = 0; j < collect.size(); j++) {
            visited = new boolean[201];
            board = new int[T];
            dfs(0);
        }
        System.out.println(res);
    }

    static void dfs(int depth) {
        if (depth == T) {
//            System.out.println(Arrays.toString(board));
            int total = 0;
            for (int i = 0; i < board.length - 1; i++) {
                total += Math.abs(board[i] - board[i + 1]);
            }
//            System.out.println("total = " + total);
//            res = Math.max(res, total);
        }
        for (int i = 0; i < collect.size(); i++) {
            if (!visited[i]) {
                System.out.println("-> :" + collect.get(i));
                visited[i] = true;
                board[depth] = collect.get(i);
                System.out.println("board-> :" + Arrays.toString(board));
                dfs(depth + 1);
                visited[i] = false;
                board[depth] = -1;
            }
        }
    }
}
