package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2579 {
    static int[] dynamic;
    static int[] stairs;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dynamic = new int[301];
        stairs = new int[301];
        for(int i = 0; i < T; i++) {
            stairs[i + 1] = Integer.parseInt(br.readLine());
        }
        dynamic[1] = stairs[1];
        dynamic[2] = stairs[1] + stairs[2];
        dynamic[3] = Math.max(dynamic[0] + stairs[2], dynamic[1]) + stairs[3];

        for(int i = 4; i <= T; i++) {
            dynamic[i] = Math.max(dynamic[i - 3] + stairs[i - 1], dynamic[i - 2]) + stairs[i];
        }

        System.out.println(dynamic[T]);
    }
}
