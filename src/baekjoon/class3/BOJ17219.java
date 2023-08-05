package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BOJ17219 {
    static HashMap<String, String> map = new LinkedHashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            map.put(ss[0], ss[1]);
        }
        for(int i = 0; i < m; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}
