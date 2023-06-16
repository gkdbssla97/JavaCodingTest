package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1038 {
    static ArrayList<Long> arr;

    public static void main(String[] args) throws Exception {

        arr = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int res = 0;
        if(N <= 10) {
            System.out.println(N);
        } else if(N > 1022) {
            System.out.println(-1);
        } else {
            for(int i = 0; i < 10; i++) {
                dfs(i, 1);
            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(N));
    }
    static void dfs(long i, int depth) {
        if(depth > 10)
            return;

        arr.add(i);
        for(int j = 0; j < 10; j++) {
            if(i % 10 > j) {
//                arr.add((i * 10) + j);
                dfs((i * 10) + j, depth + 1);
            }
        }
    }
}
