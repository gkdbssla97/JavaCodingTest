package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if ((s.indexOf('-') >= 0 && s.indexOf('+') < 0)) {
            String[] split = s.split("-");
            int total = Integer.parseInt(split[0]);
            for (String num : Arrays.stream(split).skip(1).collect(Collectors.toList())) {
                total -= Integer.parseInt(num);
            }
            System.out.println(total);
        } else if ((s.indexOf('+') >= 0 && s.indexOf('-') < 0)) {
            String[] split = s.split("\\+");
            int total = 0;
            for (String num : split) {
                    total += Integer.parseInt(num);
            }
            System.out.println(total);
        }
        else {
            boolean minus = false;
            String number = "";
            int total = 0; // 총합
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    number += s.charAt(i);
                }
                if (s.charAt(i) == '-' || s.charAt(i) == '+' || i == s.length() - 1) {
                    if (minus) {
                        total -= Integer.parseInt(number);
                        number = "";
                    } else {
                        total += Integer.parseInt(number);
//                        minus = true;
                        number = "";
                    }
                    if (s.charAt(i) == '-') {
                        minus = true;
                    }
                }
            }
            System.out.println(total);
        }
    }
}
