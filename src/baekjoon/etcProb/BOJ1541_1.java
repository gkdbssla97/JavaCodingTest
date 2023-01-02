package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ1541_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sub = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < sub.length; i++) {
            String[] add = sub[i].split("\\+");
            int total = 0;
            Arrays.stream(add).forEach(System.out::println);
            for (int j = 0; j < add.length; j++) {
                total += Integer.parseInt(add[j]);
            }
            if (sum == Integer.MAX_VALUE) {
                sum = total;
            } else {
                sum -= total;
            }
        }
    }
}
