package baekjoon.in_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("0") && s[1].equals("0")) {
                break;
            }
            System.out.println(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
        }




    }
}
