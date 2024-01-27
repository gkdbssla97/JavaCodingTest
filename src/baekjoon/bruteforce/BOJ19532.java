package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ19532 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = -999; i <= 999; i++) {
            for(int j = -999; j <= 999; j++) {
                if(isAnswer(i, j, s)) {
                    System.out.println(i + " " + j);
                    System.exit(0);
                }
            }
        }
    }
    static boolean isAnswer(int x, int y, int [] s) {
        int a = s[0]; int b = s[1];
        int c = s[2]; int d = s[3];
        int e = s[4]; int f = s[5];
        return a * x + b * y == c && d * x + e * y == f;
    }
}
