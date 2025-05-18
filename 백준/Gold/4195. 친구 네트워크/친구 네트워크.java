//package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent, cnt;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int _t = Integer.parseInt(br.readLine());
            parent = new int[_t * 2];
            for (int x = 0; x < _t * 2; x++) {
                parent[x] = x;
            }
            cnt = new int[_t * 2];
            Arrays.fill(cnt, 1);
            HashMap<String, Integer> map = new HashMap<>();
            int idx = 0;
            for(int j = 0; j < _t; j++) {
                String[] s = br.readLine().split(" ");
                String a = s[0];
                String b = s[1];
                if(!map.containsKey(a)) {
                    map.put(a, idx++);
                }
                if(!map.containsKey(b)) {
                    map.put(b, idx++);
                }

                union(map.get(a), map.get(b));
                sb.append(cnt[find(map.get(a))] + "\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int find(int a) {
        if(parent[a] == a) return parent[a];
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b) {
            parent[a] = b;
            cnt[b] += cnt[a];
            cnt[a] = 1;
        } else if (a < b) {
            parent[b] = a;
            cnt[a] += cnt[b];
            cnt[b] = 1;
        }
    }
}
