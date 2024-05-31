package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13414 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);

        Set<String> set = new LinkedHashSet<>();
        for(int i = 0; i < l; i++) {
            String v = br.readLine();
            if(set.contains(v)) set.remove(v);
            set.add(v);
        }

        int cnt = 0;
        for(String i : set) {
            System.out.println(i);
            cnt++;
            if(cnt == k) break;
        }
    }
}
