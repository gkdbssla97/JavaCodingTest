package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7662_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String IOrD = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (IOrD.equals("I")) {
                    if (!treeMap.containsKey(n)) treeMap.put(n, 1);
                    else treeMap.put(n, treeMap.get(n) + 1);
                } else if (!treeMap.isEmpty()) {
                    if (n == -1) {
                        int val = treeMap.get(treeMap.firstKey()) - 1;
                        if (val == 0) treeMap.remove(treeMap.firstKey());
                        else treeMap.put(treeMap.firstKey(), val);
                    } else {
                        int val = treeMap.get(treeMap.lastKey()) - 1;
                        if (val == 0) treeMap.remove(treeMap.lastKey());
                        else treeMap.put(treeMap.lastKey(), val);
                    }
                }
            }
            if(treeMap.isEmpty()) System.out.println("EMPTY");
            else System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
        }
    }
}
