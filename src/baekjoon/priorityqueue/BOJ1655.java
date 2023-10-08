package baekjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1655 {
    static int[] board;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());

            if(maxHeap.size() == minHeap.size()) {
                maxHeap.offer(v);
            } else {
                minHeap.offer(v);
            }
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(minHeap.peek() < maxHeap.peek()) {
                    int max = maxHeap.poll();
                    int min = minHeap.poll();
                    maxHeap.offer(min);
                    minHeap.offer(max);
                }
            }
            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb.toString());
    }

}
