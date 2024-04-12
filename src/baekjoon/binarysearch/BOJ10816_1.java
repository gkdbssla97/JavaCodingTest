package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ10816_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");

        int[] A = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        String[] b = br.readLine().split(" ");

        int[] B = Arrays.stream(b).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int upper = upperBound(A, B[i]);
            int lower = lowerBound(A, B[i]);
            sb.append(upper - lower).append(" ");
        }

        System.out.println(sb.toString());
    }

    static int upperBound(int[] arr, int key) {
        int lower = 0;
        int upper = arr.length;

        while (lower < upper) {
            int mid = (lower + upper) / 2;

            if (key < arr[mid]) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }

    static int lowerBound(int[] arr, int key) {
        int lower = 0;
        int upper = arr.length;

        while (lower < upper) {
            int mid = (lower + upper) / 2;

            if (key <= arr[mid]) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return upper;
    }
}
