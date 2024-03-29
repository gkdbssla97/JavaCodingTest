package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1062 {
    static int n, k, res = 0;
    static boolean[] visited;
    static char[] selected;
    static int[] arr = new int[26];
    static ArrayList<String> words = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]) - 5;
        if(k < 0) {
            System.out.println(0);
            System.exit(0);
        }
        visited = new boolean[26];
        selected = new char[k];
        init();
        for(int i = 0;i < n; i++) {
            String str = br.readLine();
            words.add(str);
        }

        combination(0, 0);
        System.out.println(res);
    }
    static void combination(int cnt, int start) {
        if(cnt == k) {
//            System.out.println(Arrays.toString(selected));
            int[] repl = new int[26];
            for(int i = 0; i < k; i++) {
                repl[selected[i] - 'a'] = 1;
            }
            int count = 0;
            for(int i = 0; i < n; i++) {
                String s = words.get(i);
                boolean flag = true;
                for(int j = 4; j < s.length() - 4; j++) {
                    if(arr[s.charAt(j) - 'a'] == 1 ||
                    repl[s.charAt(j) - 'a'] == 1) continue;

                    flag = false;
                }
                if(flag) count++;
            }
            res = Math.max(res, count);
            return;
        }
        for(int i = start; i < 26; i++) {
            if(arr[i] == 1) continue;
            selected[cnt] = (char)(i + 'a');
            combination(cnt + 1, i + 1);
        }
    }
    static void init() {
        arr[0] = 1;
        arr['n' - 'a'] = 1;
        arr['t' - 'a'] = 1;
        arr['i' - 'a'] = 1;
        arr['c' - 'a'] = 1;
    }
}
