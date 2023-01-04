package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11727 {
    static int[] arr = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr[1] = 1;
        arr[2] = 3;

        int N = Integer.parseInt(st.nextToken());
        for (int i = 3; i <= N; i++) {
            arr[i] = 2 * arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[N]);


    }

}