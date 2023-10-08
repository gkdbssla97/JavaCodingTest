package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5710 {
    static int A, B;
    static int res = 0;
    static int total;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            A = a;
            B = b;
            if (a == 0 && b == 0) {
                break;
            }
            total = cal_watt(a);
            int first = binarySearch(B, 1, cal_watt(a) / 2);
            System.out.println(calculate(first));
        }
    }
    static int binarySearch(int target, int l, int r) {
        if(l <= r) {
            int mid = (l + r) / 2;
            int val1 = calculate(mid);
            int val2 = calculate(total - mid);
//            System.out.println("val1, val2 " + val1 + " " + val2);
//            System.out.println("val1: " + val1);
//            System.out.println("l, r, m: " + l + " " + r + " " + mid);
            if(val2 - val1 == target) {
                res = mid;
                return mid;
            } else if(val2 - val1 < target) {
                return binarySearch(target, l, mid - 1);
            } else {
                return binarySearch(target, mid + 1, r);
            }
        }
        return -1;
    }

    static int calculate(int val) {
        if(1 <= val && val <= 100) {
            return val * 2;
        } else if(101 <= val && val <= 10000) {
            return 2 * 100 + (val - 100) * 3;
        } else if(10001 <= val && val <= 1000000) {
            return 2 * 100 + (10000 - 100) * 3 + (val - 10000) * 5;
        } else {
            return 2 * 100 + (10000 - 100) * 3 + (1000000 - 10000) * 5 + (val - 1000000) * 7;
        }
    }

    static int cal_watt(int p) {
        if(p <= 200) {
            return p / 2;
        } else if(p <= 29900) {
            return (p - 200) / 3 + 100;
        } else if(p <= 4979900) {
            return (p - 29900) / 5 + 10000;
        } else {
            return (p - 4979900) / 7 + 1000000;
        }
    }
}
