package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(a[i]);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        String[] b = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int val = Integer.parseInt(b[i]);
            sb.append(map.getOrDefault(val, 0)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
