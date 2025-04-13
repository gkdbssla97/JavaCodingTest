//package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> q = new ArrayDeque<>();
        String[] s = br.readLine().split(" ");
        for (int j = 1; j <= s.length; j++) {
            int v = Integer.parseInt(s[j - 1]);
            q.offer(new int[]{v, j});
        }
        int[] e = q.pollFirst();
        System.out.println(e[1]);
        for (int j = 1; j < s.length; j++) {
//            System.out.println("j값 " + j);
            if (e[0] > 0) {
                for (int k = 1; k < e[0]; k++) {
                    q.offerLast(q.pollFirst());
                }
                e = q.pollFirst();
                System.out.println(e[1]);
            } else {
                for (int k = 1; k < Math.abs(e[0]); k++) {
                    q.offerFirst(q.pollLast());
                }
                e = q.pollLast();
                System.out.println(e[1]);
            }
        }
    }
}
/**
 * 5
 * 3 2 1 -3 -1
 * -3 -1 2 1
 * 1 2 -1
 *
 */
