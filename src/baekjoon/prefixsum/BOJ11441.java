package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer  st = new StringTokenizer(br.readLine());
        int []s = new int[N + 1];
        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }
//        for(int i = 0; i < s.length; i++)
//            System.out.print(s[i] + " ");
//        System.out.println();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(s[b] - s[a - 1]);
        }

    }
}
