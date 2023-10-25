package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2668 {
    static int[] board;
    static int target, target_cnt;
    static ArrayList<Integer> res = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i = 1; i <= n; i++) {
            board[i] = Integer.parseInt(br.readLine());
            arr.get(i).add(board[i]);
        }
        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            if(arr.get(i).get(0) == i) {
                res.add(i);
                continue;
            }
            target = i;
            dfs(i, 0);
        }
        System.out.println(res.size());
        for(int a : res) {
            System.out.println(a);
        }
    }
    static void dfs(int start, int cnt) {
        if(target == start && cnt > 0) {
            res.add(target);
            return;
        }
        for(int i = 0; i < arr.get(start).size(); i++) {
            Integer val = arr.get(start).get(i);
            if(!visited[val]) {
                visited[val] = true;
                dfs(val, cnt + 1);
            }
        }
    }
}
