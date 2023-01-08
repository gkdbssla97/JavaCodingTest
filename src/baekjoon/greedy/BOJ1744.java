package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1744 {
    static Integer[] arr;
    static boolean isZero = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int total = 0;
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        } else {
            if (Arrays.stream(arr).anyMatch(x -> x == 0)) {
                isZero = true;
            }
//            System.out.println(plus(arr));
//            System.out.println(minus(arr));
            total = plus(arr) + minus(arr);
        }
        System.out.println(Math.max(total, Arrays.stream(arr).mapToInt(x -> x).sum()));
    }

    static int plus(Integer[] ints) {
        long count = Arrays.stream(ints).filter(x -> x > 0)
                .count();
        long count_one = Arrays.stream(ints).filter(x -> x == 1)
                .count();
        int total = 0;
        if (count_one > 1) {
            for (int i = ints.length - 1; i > ints.length - (count - count_one); i -= 2) {
                total += (ints[i] * ints[i - 1]);
            }
            return total + (int)count_one;
        }
        for (int i = ints.length - 1; i > ints.length - count; i -= 2) {
            total += (ints[i] * ints[i - 1]);
        }
        if (count % 2 == 0) {
            return total;
        }
        return total + ints[ints.length - (int) count];
    }

    static int minus(Integer[] ints) {
        long count = Arrays.stream(ints).filter(x -> x < 0)
                .count();
        int total = 0;
        if (count == 1) {
            if(isZero)
                return 0;
            return ints[0];
        }
        for (int i = 0; i < count - 1; i += 2) {
            total += ints[i] * ints[i + 1];
        }
        if (count % 2 == 0) {
            return total;
        }
        if (!isZero) {
            return total + ints[(int) count - 1];
        }
        return total;
    }
}
