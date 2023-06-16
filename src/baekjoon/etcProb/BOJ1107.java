package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1107 {
    static int N, M;
    static int[] broken;
    static int[] btn;
    static int cnt = 0;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        res = Math.abs(N - 100);

        broken = new int[10];
        if (M != 0) {

            String[] s = br.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                broken[Integer.parseInt(s[i])] = 1;
            }
        }

        for (int i = 0; i <= 1000000; i++) {
            int l = check(i);
            if(l > 0) {
                int _res = Math.abs(i - N);
                res = Math.min(_res + l, res);
            }
        }
        System.out.println(res);
    }

    static int check(int num) {
        if(num == 0) {
            if (broken[num] == 1) {
                return 0;
            } return 1;
        }
        int len = 0;
        while(num > 0) {
            int t = num % 10;
            num /= 10;
            if(broken[t] == 1) {
                return 0;
            }
            len++;
        }
        return len;
    }
}
