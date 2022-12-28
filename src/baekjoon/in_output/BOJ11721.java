package baekjoon.in_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        int idx = 0;

        while (true) {
            if (idx + 10 < sentence.length()) {
                String substring1 = sentence.substring(idx, idx + 10);
                System.out.println(substring1);
                idx += 10;
            } else {
                String substring1 = sentence.substring(idx);
                System.out.println(substring1);
                break;
            }
        }

    }
}
