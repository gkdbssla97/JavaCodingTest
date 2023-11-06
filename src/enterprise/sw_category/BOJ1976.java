package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1976 {
    static int n, m;
    static boolean flag;
    static StringBuilder res;
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        parent = new int[201];
        for(int i = 0; i <= 200; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                int r = Integer.parseInt(s[j]);
                if(r == 1) {
//                    if(find(parent[i]) != find(parent[j + 1])) {
                        union(i, j + 1);
//                    }
                }
            }
        }
//        for(int i = 1; i <= 4; i++) {
//            System.out.println(find(parent[i]));
//        }
        String[] s = br.readLine().split(" ");
        int[] res = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int p = find(parent[res[0]]);
        flag = true;

        for(int i = 1; i < m; i++) {
            if(p == find(parent[res[i]])) continue;
            else {
                flag = false;
                break;
            }
        }

        if(flag)
            System.out.println("YES");
        else System.out.println("NO");

    }
    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
