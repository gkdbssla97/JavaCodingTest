package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class BOJ2776 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            HashSet<Integer> set = new LinkedHashSet<>();
            int n = Integer.parseInt(br.readLine());
            String[] s1= br.readLine().split(" ");
            for(String s: s1) {
                set.add(Integer.parseInt(s));
            }
            int m = Integer.parseInt(br.readLine());
            String[] s2= br.readLine().split(" ");
            for(String s : s2) {
                if(set.contains(Integer.parseInt(s))) {
                    sb.append("1");
                } else sb.append("0");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
