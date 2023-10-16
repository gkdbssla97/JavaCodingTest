package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BOJ20920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            if(word.length() < m) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(String str : map.keySet()) {
            arr.add(str);
        }
        Collections.sort(arr, (o1, o2) -> {
            if(map.get(o1) == map.get(o2)) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } return o2.length() - o1.length();
            } return map.get(o2) - map.get(o1);
        });
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            sb.append(str + "\n");
        }
        System.out.println(sb.toString());
    }
}
