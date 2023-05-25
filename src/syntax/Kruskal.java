package syntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kruskal {
    static int V, E;
    static int[][] board;
    // 각 노드의 부모
    static int[] parent;
    // 최종적으로 연결된 최소 신장 트리 연결 비용
    static int final_cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);

        board = new int[E][3];
        for (int i = 0; i < E; i++) {
            String[] s1 = br.readLine().split(" ");
            board[i][0] = Integer.parseInt(s1[0]);
            board[i][1] = Integer.parseInt(s1[1]);
            board[i][2] = Integer.parseInt(s1[2]);
        }
        parent = new int[V + 1];
        final_cost = 0;

        Arrays.sort(board, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // makeSet
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 낮은 비용부터 크루스칼 알고리즘 진행
        for (int i = 0; i < E; i++) {
            if(find(board[i][0]) != find(board[i][1])) {
                union(board[i][0], board[i][1]);
                final_cost += board[i][2];
                continue;
            }
        }
        System.out.println("final_cost: " + final_cost);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }
}
