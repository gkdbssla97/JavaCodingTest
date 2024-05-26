package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class BOJ3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int tmp = target - arr[i];
            if(map.containsKey(tmp)) {
                int idx = map.get(tmp);
                if(i < idx) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
