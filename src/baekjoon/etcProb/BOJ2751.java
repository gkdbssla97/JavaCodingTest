package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ2751 {
    static boolean[] arr = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr[Integer.parseInt(s) + 1000000] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000001; i++) {
            if (arr[i]) {
                sb.append(i - 1000000).append("\n");
            }
        }
        System.out.print(sb);
    }
}
