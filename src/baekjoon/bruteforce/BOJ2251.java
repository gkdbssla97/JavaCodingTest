package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2251 {
    static int A, B, C;
    static ArrayList<Integer> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ans = new ArrayList<Integer>();

        bfs();
        Collections.sort(ans);
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    static class Bottle {
        int a, b, c;

        public Bottle(int a, int b, int c) {
            super();
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }
    static void bfs() {
        Queue<Bottle> q = new LinkedList<Bottle>();
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];
        q.offer(new Bottle(0, 0, C));
        while(!q.isEmpty()) {
            Bottle cur = q.poll();
            if(visited[cur.a][cur.b][cur.c])
                continue;
            if(cur.a == 0)
                ans.add(cur.c);

            visited[cur.a][cur.b][cur.c] = true;
            // case B->A
            if (cur.a + cur.b <= A) {
                q.add(new Bottle(cur.a + cur.b, 0, cur.c));
            } else {
                q.add(new Bottle(A, cur.b - (A - cur.a), cur.c));
            }
            // case C->A
            if (cur.a + cur.c <= A) {
                q.add(new Bottle(cur.a + cur.c, cur.b, 0));
            } else {
                q.add(new Bottle(A, cur.b, cur.c - (A - cur.a)));
            }
            // case A->B
            if (cur.b + cur.a <= B) {
                q.add(new Bottle(0, cur.a + cur.b, cur.c));
            } else {
                q.add(new Bottle( cur.a - (B - cur.b), B, cur.c));
            }
            // case C->B
            if (cur.b + cur.c <= B) {
                q.add(new Bottle(cur.a, cur.b + cur.c, 0));
            } else {
                q.add(new Bottle(cur.a, B, cur.c - (B - cur.b)));
            }
            // case A->C
            if (cur.c + cur.a <= C) {
                q.add(new Bottle(0, cur.b, cur.a + cur.c));
            } else {
                q.add(new Bottle( cur.a - (C - cur.c), cur.b, C));
            }
            // case B->C
            if (cur.c + cur.b <= C) {
                q.add(new Bottle(cur.a, 0, cur.b + cur.c));
            } else {
                q.add(new Bottle(cur.a, cur.b - (C - cur.c), C));
            }
        }

    }
}
