package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1138 {
    static boolean[] visited;
    static int[] selected, arr, board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        board = new int[n];
        selected = new int[n];
        arr = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);
            arr[i] = i + 1;
        }
        dfs(board, 0, n);
    }
    static void dfs(int[] board, int cnt, int n) {
        if(cnt == n) {
            System.out.println(Arrays.toString(selected));
            if(check(n)) {
                for(int a : selected) {
                    System.out.print(a + " ");
                }
                System.exit(0);
            }
            return;
        }
        for(int i = cnt; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[cnt] = arr[i];
                dfs(board, cnt + 1, n);
                visited[i] = false;
            }
        }
    }
    static boolean check(int n) {
        int[] tmp = new int[n];

        for(int i = 0; i < n; i++) {
            int person = selected[i];
            int cnt = 0;
            for(int j = 0; j < i; j++) {
                if(selected[j] > person) {
                    cnt++;
                }
            }
            tmp[selected[i] - 1] = cnt;
        }
//        System.out.println("-> " + Arrays.toString(tmp));
        for(int i = 0; i < n; i++) {
            if(board[i] != tmp[i]) return false;
        }
        return true;
    }
}
