package baekjoon.etcProb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String IOrD = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (IOrD.equals("I")) {
                    minQueue.offer(n);
                    maxQueue.offer(n);
                    if (!map.containsKey(n)) {
                        map.put(n, 1);
                    } else map.put(n, map.get(n) + 1);
                } else if (n == 1) {
                    while(!maxQueue.isEmpty() && map.get(maxQueue.peek()) == 0)
                        maxQueue.poll();
                    if(!maxQueue.isEmpty()) {
                        map.put(maxQueue.peek(), map.get(maxQueue.peek()) - 1);
                        maxQueue.poll();
                    }
                } else {
                    while(!minQueue.isEmpty() && map.get(minQueue.peek()) == 0)
                        minQueue.poll();
                    if(!minQueue.isEmpty()) {
                        map.put(minQueue.peek(), map.get(minQueue.peek()) - 1);
                        minQueue.poll();
                    }
                }
                while(!maxQueue.isEmpty() && map.get(maxQueue.peek()) == 0)
                    maxQueue.poll();
                while(!minQueue.isEmpty() && map.get(minQueue.peek()) == 0)
                    minQueue.poll();

            }
            if(minQueue.isEmpty()) System.out.println("EMPTY");
            else System.out.println(maxQueue.peek() + " " + minQueue.peek());
//            minQueue.stream().forEach(System.out::print);
//            System.out.println();
//            maxQueue.stream().forEach(System.out::print);
//            System.out.println();
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                System.out.println("key: " + entry.getKey() + "value: " + entry.getValue());
//            }
        }
    }
}
