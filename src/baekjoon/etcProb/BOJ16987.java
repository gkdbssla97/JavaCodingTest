package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ16987 {
    static int n, max = 0;
    static ArrayList<Egg> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int S = Integer.parseInt(s[0]);
            int W = Integer.parseInt(s[1]);
            Egg e = new Egg(S, W);
            arr.add(e);
        }

//        print(eggs);

        dfs(0, arr.size(), 0, arr);

        System.out.println(max);
    }

    static void dfs(int start, int size, int cnt, List<Egg> eggs) {
        if (start >= size) {
            max = Math.max(max, cnt);
            return;
        }
        if(eggs.get(start).s <= 0 || cnt ==  n - 1) {
            dfs(start + 1, size, cnt,  eggs);
            return;
        }

        int curCnt = cnt;
        Egg cur = eggs.get(start);
        for (int i = 0; i < size; i++) {
            Egg next = eggs.get(i);
            if (i == start) continue;
            if (arr.get(i).s <= 0) continue;

            cur.s -= next.w; // 손에 든 계란 Hit
            next.s -= cur.w; // 타겟 계란 Hit

            // 손에 든 계란 깨졌는가? OR 타겟 계란 깨졌는가?
            if (cur.s <= 0) {
                cnt++;
            }
            if (next.s <= 0) {
                cnt++;
            }

            dfs(start + 1, size, cnt, eggs);
            cnt = curCnt;
            cur.s += next.w; // 손에 든 계란 Hit
            next.s += cur.w; // 타겟 계란 Hit
        }
    }

    static void print(List<Egg> eggs) {
        for (Egg e : eggs) {
            System.out.println(e.s + " " + e.w);
        }
    }

    static class Egg {
        int s, w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}
