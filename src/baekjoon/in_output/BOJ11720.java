package baekjoon.in_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String[] split = s.split("");
        int sum = 0;
        for (String num : split) {
            sum += Integer.parseInt(num);
        }
        System.out.println(sum);
    }
}
