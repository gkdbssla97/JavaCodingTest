package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11286 {
    static int N;
    static PriorityQueue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1: o2 ->" + o1 + " " + o2);
                int i = Math.abs(o1) - Math.abs(o2);
                if (i == 0)
                    return o1 - o2;
                return i;
            }
        });
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            q.offer(num);
//            if(num == 0) {
//                if (!q.isEmpty())
//                    System.out.println(q.poll());
//                else System.out.println(0);
//            } else
//                q.offer(num);
        }
        while(!q.isEmpty())
            System.out.println(q.poll());
    }
}
