package programmers.highscorekit.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    static PriorityQueue<Integer> q;
    public static int solution(int[] scoville, int K) {
        q = new PriorityQueue<>();
        for(int s : scoville) {
            q.offer(s);
        }
        int cnt = 0;
        while(q.peek() < K) {

            if(q.size() == 1) {
                return -1;
            }

            int a = q.poll();
            int b = q.poll();

            int res = a + (2 * b);

            q.offer(res);
            cnt++;

        }
        int answer = 0;

        return cnt;
    }

    public static void main(String[] args) {
        int[] s = {1,2,3,9,10,12};
        int k = 7;
        System.out.println(solution(s, k));
    }
}
