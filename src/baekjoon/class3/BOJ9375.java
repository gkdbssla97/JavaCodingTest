package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BOJ9375 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int answer = 1;
            HashMap<String, Integer> map = new LinkedHashMap<>();
            int w = Integer.parseInt(br.readLine());
            for(int j = 0; j < w; j++) {
                String[] s = br.readLine().split(" ");
                map.put(s[1], map.getOrDefault(s[1], 0) + 1);
            }
//            System.out.println(map);
//            System.out.println(map.values().size());

            for(int value : map.values()) {
                answer *= (value + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
