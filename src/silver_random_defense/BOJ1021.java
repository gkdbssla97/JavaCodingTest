package silver_random_defense;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n =  Integer.parseInt(s[0]);
        int m =  Integer.parseInt(s[1]);
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }

        s = br.readLine().split(" ");
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            Integer v = Integer.parseInt(s[i]);
            int idx = q.indexOf(v);
            int halfIndex;
            if(q.size() % 2 == 0) {
                halfIndex = q.size() / 2 - 1;
            } else {
                halfIndex = q.size() / 2;
            }
            if(idx <= halfIndex) {
                while(q.peekFirst() != v) {
                    Integer p = q.pollFirst();
                    q.offerLast(p);
                    cnt++;
                }
            } else {
                while(q.peekFirst() != v) {
                    Integer p = q.pollLast();
                    q.offerFirst(p);
                    cnt++;
                }
            }
            q.pollFirst();
        }
        System.out.println(cnt);
    }
}
