package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603_1 {
    static int[] arr;
    static boolean[] visited;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("0"))
                break;
            arr = new int[Integer.parseInt(s[0])];
            visited = new boolean[Integer.parseInt(s[0])];
            res = new int[Integer.parseInt(s[0])];
            for (int i = 1; i < s.length; i++) {
                arr[i - 1] = Integer.parseInt(s[i]);
            }
            combination_BFS(0, s.length, 6);
        }
    }

    static void combination_BFS(int start, int n, int r) {
        if (r == 0) {
            for (int x : res) {
                if(visited[x]) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
        if(start == n)
            return;
        visited[start] = true;
        combination_BFS(start + 1, n, r - 1);
        visited[start] = false;
        combination_BFS(start + 1, n, r);
    }
}
