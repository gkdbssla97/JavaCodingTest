package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ11399 {
    static int[] prefix_sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        prefix_sum = new int[N + 1];
        List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
//        collect.stream().forEach(System.out::print);
        for (int i = 1; i <= collect.size(); i++) {
            prefix_sum[i] = prefix_sum[i - 1] + collect.get(i - 1);
        }
//        prefix_sum[0] = collect.get(0);
        System.out.println(IntStream.of(prefix_sum).sum());

    }
}
