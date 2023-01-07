package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BOJ1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> calendar = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Integer a, b, c;
        a = 1;
        b = 1;
        c = 1;
        int i;
        for ( i = 1; ; i++) {
            if (calendar.get(0).equals(a) && calendar.get(1).equals(b)
                    && calendar.get(2).equals(c)) {
                break;
            }
                a++;
                b++;
                c++;
                if (a == 16) {
                    a = 1;
                }
                if (b == 29) {
                    b = 1;
                }
                if (c == 20) {
                    c = 1;
                }
            }
        System.out.println(i);
    }
}
