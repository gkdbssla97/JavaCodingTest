package programmers.kakao.TECHINTERNSHIP2022;

import java.util.*;

    class 두큐합같게만들기 {
        static long res = -1;
        public long solution(int[] queue1, int[] queue2) {
            long ans1 = 0;
            long ans2 = 0;
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            for(int q : queue1) {
                ans1 += q;
                q1.offer(q);
            }
            for(int q : queue2) {
                ans2 += q;
                q2.offer(q);
            }
            // ans1 == ans2
            if(ans1 == ans2) {
                return 0;
            } else {
                long idx = 0;
                while(idx <= 600_000) {
                    if(ans1 > ans2) {
                        int n = q1.poll();
                        q2.offer(n);
                        ans1 -= n;
                        ans2 += n;
                    } else if(ans1 < ans2) {
                        int n = q2.poll();
                        q1.offer(n);
                        ans2 -= n;
                        ans1 += n;
                    } else {
                        res = idx;
                        break;
                    }
                    idx++;
                }
            }
            // ans1 > ans2
            // ans2 > ans1

            System.out.println(res);
            return (res >= 600000)? -1 : res;
        }
    }
