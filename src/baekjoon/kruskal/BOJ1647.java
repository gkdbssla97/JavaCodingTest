package baekjoon.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1647 {
    static int N, M;
    static int[][] board;
    static int[] parent;
    static int final_cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        board = new int[M][3];
        parent = new int[N + 1];
        final_cost = 0;

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Arrays.sort(board, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i = 0; i < M; i++) {
            String[] ss = br.readLine().split(" ");
            board[i][0] = Integer.parseInt(ss[0]);
            board[i][1] = Integer.parseInt(ss[1]);
            board[i][2] = Integer.parseInt(ss[2]);
        }

        for (int i = 0; i < M; i++) {
            if(find(board[i][0]) != find(board[i][1])) {
                union(board[i][0], board[i][1]);
                final_cost += board[i][2];
                continue;
            }
        }
        System.out.println(final_cost);
    }
    static int find(int a) {
        if(parent[a] == a) {
            return parent[a];
        }
        return find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}
