package baekjoon.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1922 {
    static int N, M;
    static int V, E;
    static int[][] board;
    static int[] parent;
    static int final_cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);

        board = new int[M][3];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            board[i][0] = Integer.parseInt(s[0]);
            board[i][1] = Integer.parseInt(s[1]);
            board[i][2] = Integer.parseInt(s[2]);
        }

        Arrays.sort(board, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        int big_cost = 0;
        for (int i = 0; i < M; i++) {
            if (find(board[i][0]) != find(board[i][1])) {
                union(board[i][0], board[i][1]);
                final_cost += board[i][2];
                big_cost = board[i][2];
            }
        }
        System.out.println(final_cost - big_cost);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return parent[a];
        }
        return find(parent[a]);
    }
}
