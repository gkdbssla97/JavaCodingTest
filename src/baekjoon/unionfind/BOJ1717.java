package baekjoon.unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1717 {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if (a == 1) {
                if (find(b) == find(c)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            } else {
                union(b, c);
            }
        }
        System.out.println(sb.toString());
        System.out.println(Arrays.toString(parent));
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    //[0, 1, 2, 1, 2, 5, 1, 6]
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) parent[a] = b;
        else if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

}
