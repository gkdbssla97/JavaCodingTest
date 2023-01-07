package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ10610 {
    static int[] arr;
    static int[] output;
    static double res = 0;
    static boolean[] visited;
    static int len;
    static List<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();

        numbers = Arrays.stream(N.split(""))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (!numbers.contains(0)) {
            System.out.println(-1);
            return;
        }
        int total = 0;
        for (int i : numbers) {
            total += i;
        }
        if (total % 3 == 0) {
            numbers.stream().forEach(System.out::print);
        } else {
            System.out.println(-1);
        }
    }

}
