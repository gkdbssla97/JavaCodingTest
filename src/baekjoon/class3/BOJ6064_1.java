package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064_1 {
    static int N;
    static int res = -1;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int j;
            for (j = x; j <= M*N; j += M) {
                res = -1;
                int tmp = j % N;
                if (tmp == 0) {
                    tmp = N;
                }
                if (tmp == y) {
                    res = j;
//                    System.out.println(j);
//                    check = true;
                    break;
                }
            }

            System.out.println(res);
        }
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
