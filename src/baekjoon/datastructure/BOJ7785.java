package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String name = s[0];
            String status = s[1];

            if(status.equals("enter")) {
                map.put(name, map.getOrDefault(name, 0) + 1);
            } else {
                map.put(name, map.getOrDefault(name, 1) - 1);
            }
        }
        List<String> arr = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0) {
                arr.add(entry.getKey());
            }
        }
        Collections.sort(arr, Collections.reverseOrder());
        for(String name : arr) {
            System.out.println(name);
        }
    }
}
