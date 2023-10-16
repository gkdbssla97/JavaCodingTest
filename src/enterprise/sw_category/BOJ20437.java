package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BOJ20437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int[] a = func1(w, k);
            if(a.length == 1) {
                System.out.println(-1);
            } else {
                System.out.println(a[0] + " " + a[1]);
            }
        }

    }
    static int[] func1(String w, int k) {
        int res = 10001;
        int res1 = 0;
        for(int i = 0; i < w.length(); i++) {
            int[] alphabet = new int[26];
            for(int j = i; j < w.length(); j++) {
                alphabet[w.charAt(j) - 'a'] += 1;
                if(alphabet[w.charAt(j) - 'a'] == k) {
                    res = Math.min(res, j - i + 1);
                }
                if(alphabet[w.charAt(j) - 'a'] == k && w.charAt(j) == w.charAt(i)) {
                    res1 = Math.max(res1, j - i + 1);
                }
            }
        }
        if(res == 10001 || res1 == 0) {
            return new int[]{-1};
        }
        return new int[]{res, res1};
    }

    static int func2(String w, int k) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while(left <= right && right < w.length()) {
            map.put(w.charAt(right), map.getOrDefault(w.charAt(right), 0) + 1);
            if(map.containsKey(w.charAt(right)) && map.get(w.charAt(right)) == k) {
                while(true) {
                    if(map.get(w.charAt(right)) != k) {
//                        System.out.println(w.charAt(right) + " " + right);
//                        System.out.println(map.get(w.charAt(right)));
                        res = Math.max(res, right - left + 2);
//                        System.out.println("res : " + res);
                        break;
                    }
                    map.put(w.charAt(left), map.get(w.charAt(left)) - 1);
                    left++;
                }
            }
            right++;
//            print(map);
//            System.out.println("--");
        }
        return res;
    }
    static void print(HashMap<Character, Integer> map) {
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
