package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2875 {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 여
        M = Integer.parseInt(st.nextToken()); // 남
        K = Integer.parseInt(st.nextToken()); // 인턴십

        int cnt = 0;
        while (N >= 2 && M >= 1 && N + M - 3 >= K) {
            N -= 2;
            M--;
            cnt++;
        }
        System.out.println(cnt);
    }
}
