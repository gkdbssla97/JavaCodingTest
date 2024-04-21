package silver_random_defense;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BOJ1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        Arrays.sort(s);
        String[] res = new String[s.length];
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String str : s) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int left = 0;
        int right = res.length - 1;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 == 0) {
                while (value != 0) {
                    res[left++] = entry.getKey();
                    res[right--] = entry.getKey();
                    value -= 2;
                }
            } else {
                while (value != 1) {
                    res[left++] = entry.getKey();
                    res[right--] = entry.getKey();
                    value -= 2;
                }
                if(res.length % 2 == 0) {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                } else {
                    if(res[res.length / 2] == null) {
                        res[res.length / 2] = entry.getKey();
                    } else {
                        System.out.println("I'm Sorry Hansoo");
                        System.exit(0);
                    }
                }
            }
        }
        String join = String.join("", res);
        System.out.println(join);
    }
}
