package baekjoon.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1068 {
    static int n, cnt = 0;
    static int[] board;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        visited = new boolean[n];
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);
            if (board[i] == -1) {
                root = i;
                continue;
            }
            arr.get(board[i]).add(i);
        }
        int node = Integer.parseInt(br.readLine());
        deleteNodes(node);

//        for (int i = 0; i < n; i++) {
//            System.out.println(arr.get(i) + " " + arr.get(i).size());
//        }

        dfs(root, node);
        System.out.println(cnt);
    }
    static void deleteNodes(int node) {
        visited[node] = true;
        for (int i = 0; i < arr.get(node).size(); i++) {
            int v = arr.get(node).get(i);
            if(!visited[v]) {
                deleteNodes(v);
            }
        }
    }
    static void dfs(int start, int node) {
        if(visited[start]) return;
        int nCount = 0;

        for (int i = 0; i < arr.get(start).size(); i++) {
            int idx = arr.get(start).get(i);
            if (!visited[idx]) {
                dfs(idx, node);
                nCount++;
            }
        }
        if(!visited[start] && nCount == 0) {
            cnt++;
        }
    }
}
