package programmers.kakao.TECHINTERNSHIP2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public static long solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long q1_sum = Arrays.stream(queue1).sum();
        long q2_sum = Arrays.stream(queue2).sum();
        long total_sum = q1_sum + q2_sum;

        Queue<Integer> q1 = intArrToQueue(queue1);
        Queue<Integer> q2 = intArrToQueue(queue2);

        if(total_sum % 2 != 0) return -1;
        total_sum /= 2;

        while (q1_sum != total_sum) {
            if (q1_sum < total_sum) {
                int poll = q2.poll();
                q1.offer(poll);
                q1_sum += poll;
            } else {
                int poll = q1.poll();
                q2.offer(poll);
                q1_sum -= poll;
            }
            answer++;

            if(answer > (queue1.length * 4)) {
                return -1;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private static Queue<Integer> intArrToQueue(int[] queue1) {
        Queue<Integer> q = new LinkedList<>();
        for (int i : queue1) {
            q.offer(i);
        }
        return q;
    }

    private static long sumQueue(Queue<Integer> q) {
        long total = 0;
        for (Integer i : q) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};

//        int[] queue1 = {1, 1};
//        int[] queue2 = {1, 5};

        solution(queue1, queue2);
    }


}
