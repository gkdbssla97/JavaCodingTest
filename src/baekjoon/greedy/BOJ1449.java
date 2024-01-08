package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1449 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        if(l == 1) {
            System.out.println(n);
            System.exit(0);
        }
        int cnt = 1;
        int right = 0;
        int left = 0;
        while(left <= right && right < n) {
            if (arr[right] - arr[left] + 1 <= l) {
                right++;
            } else {
                cnt++;
                left = right;
            }
        }
        System.out.println(cnt);
    }
}
