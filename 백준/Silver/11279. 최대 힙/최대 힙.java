// package syntax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>((p, q) -> q - p);

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.offer(v);
            }
        }
    }
}
/**
 0
 2
 1
 3
 2
 1
 0
 0
 */
