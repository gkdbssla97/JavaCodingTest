package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
    static int N;
    static int K;
    static int[] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(countCoin());
    }
    static int countCoin() {
        int cnt = 0;
        while (K != 0) {
            for (int i = coin.length - 1; i >= 0; i--) {
                if (K < coin[i]) {
                    continue;
                } cnt += K / coin[i];
                K %= coin[i];
            }
        } return cnt;
    }
}
