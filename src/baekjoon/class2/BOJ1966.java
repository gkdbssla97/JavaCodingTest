package baekjoon.class2;

import javax.transaction.xa.XAException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            Queue<Node> q = new LinkedList<>();
            s = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < s.length; i++) {
                int val = Integer.parseInt(s[i]);
                arr[i] = val;
                q.offer(new Node(i, val));
            }
            Arrays.sort(arr);
            int cnt = 1;
            int idx = n - 1;
            while (!q.isEmpty()) {
                Node poll = q.poll();
                if (poll.cost == arr[idx]) {
                    if (poll.idx == m) {
                        break;
                    }
                    idx--;
                    cnt++;
                }
                if (poll.idx == m && poll.cost == arr[idx]) {
                    break;
                } else {
                    q.offer(poll);
                }
            }
            System.out.println(cnt);
        }
    }

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
