package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ17609 {
    static int[] idx;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            int res = check(s);
            if(res == 0) {
                System.out.println(0);
            } else {
                System.out.println(_check(s));
            }
        }
    }
    static int _check(String str) {
        int len = str.length();
        int left = 0;
        int right = len - 1;
        boolean flag = true;
        while(left <= right) {
            if(left == idx[0]) left++;
            if(str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                flag = false;
                break;
            }
        }
        if(flag) return 1;
        left = 0;
        right = len - 1;
        flag = true;
        while(left <= right) {
            if(right == idx[1]) right--;
            if(str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                flag = false;
                break;
            }
        }
        if(flag) return 1;
        return 2;
    }

    static int check(String str) {
        int len = str.length();
        int left = 0;
        int right = len - 1;
        boolean flag = true;
        idx = new int[2];
        while(left <= right) {
            if(str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                flag = false;
                idx[0] = left;
                idx[1] = right;
                break;
            }
        }
        if(flag) return 0;
        return -1;
    }
}
