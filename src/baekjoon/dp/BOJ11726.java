package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    static int[] arr = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 2;

        if (N <= 2) {
            System.out.println(arr[N] % 10007);
        } else {
            for (int i = 1; i <= N - 2; i++) {
                arr[i + 2] = (arr[i] % 10007) + (arr[i + 1] % 10007);
            }
            System.out.println(arr[N] % 10007);
        }
    }
}