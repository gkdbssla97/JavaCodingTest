package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int node;
    static int vertex;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        vertex = Integer.parseInt(br.readLine());
        visited = new boolean[node + 1];

        for (int i = 0; i <= node; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < vertex; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        visited[1] = true;
        dfs(1);
        int cnt = 0;
        for(boolean b : visited) {
            if(b) cnt++;
        }
        System.out.println(Arrays.toString(visited));
        System.out.println(cnt - 1);
    }
    static void dfs(int start) {

        for(int i = 0; i < arr.get(start).size(); i++) {
            int next = arr.get(start).get(i);
            if(!visited[next]){
                System.out.println("node ->" + next);
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
