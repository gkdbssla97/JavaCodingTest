package baekjoon.in_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());

        //Top
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (int k = 1; k <= (2 * a) - (i * 2); k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //Bottom
        for (int i = 1; i <= a - 1; i++) {
            for (int j = i; j <= a - 1; j++) {
                System.out.print("*");
            }
            for (int k = 1; k <= 2 * (i + 1) - 2; k++) {
                System.out.print(" ");
            }
            for (int j = i; j <= a - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
