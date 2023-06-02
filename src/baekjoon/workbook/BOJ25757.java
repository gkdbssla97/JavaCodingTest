package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ25757 {
    static int N, cnt;
    static String G;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        G = s[1];

        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }
        int size = hashSet.size();
        visited = new boolean[size];

        cnt = 0;
        if(G.equals("Y")) {
//            combination(size, 1, 0);
            cnt = size;
        } else if(G.equals("F")) {
//            combination(size, 2, 0);
            cnt = size / 2;
        } else {
//            combination(size, 3, 0);
            cnt = size / 3;
        }
//        System.out.println(size);
//        System.out.println(hashSet.toString());
        System.out.println(cnt);
    }
    static void combination(int n, int r, int start) {
        if(r == 0) {
            cnt++;
            return;
        }
        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(n, r - 1, start + 1);
            visited[i] = false;
        }
    }
}
