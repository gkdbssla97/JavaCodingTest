package baekjoon.in_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= a - 1; i++) {
            for (int j = 1; j <= a - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            if (i == 1) {
                System.out.println();
                continue;
            }
            for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        for (int i = 1; i <= 2 * a - 1; i++) {
            System.out.print("*");
        }
        System.out.println();

    }
}
