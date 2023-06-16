package baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ19942 {
    static int N, mp, mf, ms, mv;
    static int[][] board;
    static ArrayList<String> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");

        mp = Integer.parseInt(a[0]);
        mf = Integer.parseInt(a[1]);
        ms = Integer.parseInt(a[2]);
        mv = Integer.parseInt(a[3]);

        board = new int[N][5];
        for (int i = 0; i < N; i++) {
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < ss.length; j++) {
                board[i][j] = Integer.parseInt(ss[j]);
            }
        }
        /**
         * ---clear---
         */


        ArrayList<Integer> res = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        StringBuilder sb;
        list = new ArrayList<>();
        for (int i = 1; i < (1 << N); i++) {
            sb = new StringBuilder();
            int p = 0;
            int f = 0;
            int s = 0;
            int v = 0;
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
//                    System.out.print(Arrays.toString(board[j]) + " ");
                    //System.out.print((j + 1) + " ");
                    sb.append((j + 1) + " ");
                    p += board[j][0];
                    f += board[j][1];
                    s += board[j][2];
                    v += board[j][3];
                    sum += board[j][4];
                }
            }
//            System.out.println();
            if (p >= mp && f >= mf && s >= ms && v >= mv) {
                if(max >= sum) {
                    if(max > sum) {
                        list.clear();
                    }
                    list.add(sb.toString());
                    max = sum;
//                    System.out.println(sb);
                }
            }
        }
//        System.out.println(list);
        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(max);
            Collections.sort(list);
            String s = list.get(0);
            for(int i = 0; i < s.length(); i++){
                System.out.print(s.charAt(i));
            }
//            System.out.println();
        }
    }
}
