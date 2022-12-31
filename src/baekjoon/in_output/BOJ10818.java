package baekjoon.in_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] s = br.readLine().split(" ");
        int idx = Integer.parseInt(st.nextToken());
        List<Integer> collect = Arrays.stream(s)
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
        Collections.sort(collect);
        System.out.println(collect.get(0) + " " + collect.get(collect.size() - 1));
    }
}
