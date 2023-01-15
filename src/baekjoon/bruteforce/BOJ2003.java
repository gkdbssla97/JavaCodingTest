package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ2003 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int cnt = 0;
        int sum = 0;
        int startPoint = 0, endPoint = 0;
        while (true) {
            if (sum >= M) {
                sum -= collect.get(startPoint++);
            }
            else if (endPoint == collect.size())
                break;
            else
                sum += collect.get(endPoint++);
            if(sum == M)
                cnt++;
        }
        System.out.println(cnt);
    }
}
