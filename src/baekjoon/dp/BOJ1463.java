package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1463 {
    static boolean[] visited = new boolean[1000000];
    static int total = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        dfs(X, 0);
        System.out.println(total);
    }

    static void dfs(int X, int cnt) {

        if (X == 1) {
            if (cnt < total) {
                total = cnt;
                return;
            }
        } else {
            if (cnt >= total) {
                return;
            }
//            System.out.println("!");
            if (X % 3 == 0 && !visited[X / 3]) {
                visited[X / 3] = true;
//                System.out.println(X / 3);
                dfs(X / 3, cnt + 1);
                visited[X / 3] = false;
            } if (X % 2 == 0 && !visited[X / 2]) {
                visited[X / 2] = true;
//                System.out.println(X / 2);
                dfs(X / 2, cnt + 1);
                visited[X / 2] = false;
            } if (!visited[X - 1]) {
                    visited[X - 1] = true;
//                    System.out.println(X - 1);
                    dfs(X - 1, cnt + 1);
                    visited[X - 1] = false;
                }
            }
//            System.out.println(total);
        }
}