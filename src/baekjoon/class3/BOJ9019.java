package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ9019 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int target = Integer.parseInt(s[1]);
            StringBuilder sb = new StringBuilder();
            boolean[] visited = new boolean[10001];
            String[] cmd = new String[10001];
            Arrays.fill(cmd, "");
            bfs(start, visited, cmd);
            System.out.println(cmd[target]);
        }
    }

    static void bfs(int start, boolean[] visited, String[] cmd) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            int D = (2 * now) % 10000;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + (now / 1000);
            int R = (now % 10) * 1000 + (now / 10);

            if (!visited[D]) {
                visited[D] = true;
                q.offer(D);
                cmd[D] = cmd[now] + "D";
            }
            if (!visited[S]) {
                visited[S] = true;
                q.offer(S);
                cmd[S] = cmd[now] + "S";
            }
            if (!visited[L]) {
                visited[L] = true;
                q.offer(L);
                cmd[L] = cmd[now] + "L";
            }
            if (!visited[R]) {
                visited[R] = true;
                q.offer(R);
                cmd[R] = cmd[now] + "R";
            }
        }
    }
}

// 1234
// 2341
// 3412
// 4123
// 1234
