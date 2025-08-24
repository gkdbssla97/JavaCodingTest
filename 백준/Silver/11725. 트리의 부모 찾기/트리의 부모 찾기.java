// package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    static int res;
    static List<ArrayList<Integer>> arr;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        
        parent = new int[n + 1];
        parent[1] = 0;
        
        visited = new boolean[n + 1];

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
    
    static void dfs(int start) {
        for (int i = 0; i < arr.get(start).size(); i++) {
            Integer v = arr.get(start).get(i);
            if (!visited[v]) {
                parent[v] = start;
                visited[v] = true;
                dfs(v);
            }
        }
    }
}
/**
 * 4
 * 6
 * 1
 * 3
 * 1
 * 4
 */
