package baekjoon.in_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());

        int space = 0;
        int star = a;
        for (int i = 0; i < a; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = i + 1; j <= star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
