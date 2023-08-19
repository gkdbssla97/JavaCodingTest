package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2666 {
    static int ans = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());
        arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        go(m, 0, 0, Integer.parseInt(s[0]) - 1, Integer.parseInt(s[1]) - 1);
        System.out.println(ans);
    }
    static void go(int m, int lv, int cnt, int left, int right) {
        if(lv == m) {
            System.out.println(cnt);
            ans = Math.min(ans, cnt);
            return;
        }

        int a = Math.abs(left - arr[lv]);
        int b = Math.abs(right - arr[lv]);
//        System.out.println("1:a, b, p -> " + a + " " + b);
        go(m, lv + 1, cnt + a, arr[lv], right);
//        System.out.println("2:a, b, p -> " + a + " " + b);
        go(m, lv + 1, cnt + b, left, arr[lv]);

    }
}
