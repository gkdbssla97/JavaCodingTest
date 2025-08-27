import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) pq.offer(s);
        if(pq.peek() >= K) return answer;
        while(true) {
            if(pq.size() >= 2) {
                int p = pq.poll();
                int q = pq.poll();
                pq.offer(p + q * 2);
                answer++;
            }
            if(pq.peek() >= K) {
                break;
            }
            if(pq.size() == 1) return -1;
        }
        
        return answer;
    }
}