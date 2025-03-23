//package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int v = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        String[] s1 = br.readLine().split(" ");
        for(int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        int[] prefix = new int[n + 2];
        for(int i = 0; i < n; i++) {
            prefix[i + 1] = arr[i] + prefix[i];
        }
        //0 5 9 12 14 15 0
//        Arrays.stream(prefix).forEach(System.out::print);
        for(int i = 0; i < v; i++) {
            String[] s2 = br.readLine().split(" ");
            int i1 = Integer.parseInt(s2[0]);
            int i2 = Integer.parseInt(s2[1]);
            System.out.println(prefix[i2] - prefix[i1 - 1]);
        }


    }
}
