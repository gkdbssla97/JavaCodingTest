package baekjoon.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ15681 {
    static int n, r, q, res;
    static boolean[] visited;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]);

        for(int i = 0; i <= n ; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++) {
            String[] ss = br.readLine().split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        visited = new boolean[n + 1];
        visited[r] = true;
        dp = new int[n + 1];
        dfs(r);
        System.out.println(Arrays.toString(dp));
        for(int i = 0; i < q; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
    static int dfs(int start)  {
//        System.out.println("node ->" + start);
        if(dp[start] != 0) {
            return 0;
        }

        dp[start] = 1;
        for(int i = 0; i < arr.get(start).size(); i++) {
            Integer node = arr.get(start).get(i);
            if(!visited[node]) {
                visited[node] = true;
                dp[start] += dfs(node);
            }
        }
        return dp[start];
    }
}
