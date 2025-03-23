//package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).sorted().toArray();
        int[] gap = new int[array.length - 1];
        for(int i = 1; i < array.length; i++) {
            gap[i - 1] = array[i] - array[i - 1];
        }
//        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
//        System.out.println();
        gap = Arrays.stream(gap).sorted().toArray();
        int sum = 0;
        for(int i = 0; i < a - b; i++) {
            sum += gap[i];
        }
        System.out.println(sum);
    }
}
