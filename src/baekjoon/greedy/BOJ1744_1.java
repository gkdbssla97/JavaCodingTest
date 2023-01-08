package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ1744_1 {
    static List<Integer> negative;
    static List<Integer> positive;
    static int[] zeroAndOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        negative = new ArrayList<>();
        positive = new ArrayList<>();
        zeroAndOne = new int[2];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positive.add(num);
            } else if (num < 0) {
                negative.add(num);
            } else zeroAndOne[num]++;
        }
        Collections.sort(negative);
        positive.sort(Collections.reverseOrder());

        int total = 0;

        if (negative.size() > 1) {
            for (int i = 0; i < negative.size() - 1; i += 2) {
                total += (negative.get(i) * negative.get(i + 1));
            }
        }
        if (negative.size() % 2 == 1 && zeroAndOne[0] == 0) {
            total += negative.get(negative.size() - 1);
        }

        if (positive.size() > 1) {
            for (int i = 0; i < positive.size() - 1; i += 2) {
                total += (positive.get(i) * positive.get(i + 1));
            }
        }
        if (positive.size() % 2 == 1) {
            total += positive.get(positive.size() - 1);
        }

        total += zeroAndOne[1];
        System.out.println(total);
    }
}
