package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int start_x = 1, start_y = 1;
            int year;
            for (year = 1;; year++) {
                if (start_x == x && start_y == y) {
                    System.out.println(year);
                    break;
                }
                if (start_x == M && start_y == N) {
                    System.out.println(-1);
                    break;
                }
                if(start_x == M + 1)
                    start_x = 1;
                if(start_y == N + 1)
                    start_y = 1;
                start_x++;
                start_y++;
            }
        }
    }
}
