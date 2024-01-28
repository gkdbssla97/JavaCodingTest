package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BOJ24511 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] type;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        type = new int[n];
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            type[i] = Integer.parseInt(A[i]);
            if (type[i] == 1) continue;
            else flag = true;
            int v = Integer.parseInt(B[i]);
            arr.get(i).add(v);
        }

        int m = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (type[i] == 0) {
                dq.addLast(Integer.parseInt(B[i]));
            }
        }
        String[] s = br.readLine().split(" ");
        if (!flag) System.out.println(String.join(" ", s));
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int v = Integer.parseInt(s[i]);
                dq.addFirst(v);
                sb.append(dq.pollLast() + " ");
            }
            System.out.println(sb.toString());
        }
    }
}
/**
 * 4
 * 0 1 0 1
 * 1 2 3 4
 * 3
 * 2 4 7
 */
