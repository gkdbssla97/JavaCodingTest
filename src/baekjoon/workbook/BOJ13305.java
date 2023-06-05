package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13305 {
    static long N;
    static long[] distance;
    static long[] city;
    static long min, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        String[] s = br.readLine().split(" ");

        distance = new long[(int) (N - 1)];
        city = new long[(int) N];
        max = -1;
        min = Integer.MAX_VALUE;

        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            distance[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < ss.length; i++) {
            city[i] = Integer.parseInt(ss[i]);
        }
        long res = city[0] * distance[0];
        min = city[0];
        for (int i = 1; i < ss.length - 1; i++) {
            if (min > city[i]) {
                min = city[i];
                res = res + distance[i] * min;
            } else {
                res = res + distance[i] * min;
            }
        }
        System.out.println(res);
    }

    /**
     * 빗물과 같은 원리?
     */
}
