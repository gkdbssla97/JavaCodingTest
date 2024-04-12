package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        int[] A = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(b).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);
        Arrays.sort(B);
        int res = 0;

        for(int i = 0; i < n; i++) {
            res = (A[i] * B[n - 1 - i]) + res;
        }
        System.out.println(res);
    }
}
