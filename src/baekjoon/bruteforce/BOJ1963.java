package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1963 {
    static int T, a, b;
    static boolean[] isPrime = new boolean[10001];
    static boolean[] visited;
    static int[] step;

    static void prime() {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i < 10000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < 10000; j += i)
                    isPrime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        prime();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == b) {
                System.out.println(0);
                continue;
            }
            visited = new boolean[10001];
            step = new int[10001];
            bfs(a);
        }
    }
    static void bfs(int val) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(val);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            visited[poll] = true;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (step[b] > 0) {
                        System.out.println(step[b]);
                        return;
                    }
                    Integer changeNum = changeNum(i, j, poll);
//                    System.out.println(changeNum);
                    if (!isPrime[changeNum] && !visited[changeNum]) {
                        visited[changeNum] = true;
                        step[changeNum] = step[poll] + 1;
                        q.offer(changeNum);
                    }
                }
            }
        }
    }
    static Integer changeNum(int i, int j, int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(i, (char)(j + '0'));
        return Integer.valueOf(sb.toString());
    }
}
