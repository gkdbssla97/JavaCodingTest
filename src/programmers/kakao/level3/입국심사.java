package programmers.kakao.level3;

import java.util.*;
/**
 통과 (1.58ms, 69.5MB)
 테스트 4 〉	통과 (30.60ms, 77.5MB)
 테스트 5 〉	통과 (51.11ms, 90.2MB)
 테스트 6 〉	통과 (37.37ms, 87.3MB)
 테스트 7 〉	통과 (53.99ms, 89.7MB)
 테스트 8 〉	통과 (64.20ms, 91.5MB)
 테스트 9 〉	통과 (0.08ms, 78.4MB)
 **/
class 입국심사 {
    static long min, max;
    static long answer;
    static long len;
    public long solution(int n, int[] times) {
        answer = (long)1e18;
        long len = (long)times.length;
        min = (long)times[0];
        max = (long)times[0] * n;

        binarySearch(times, n);
        return answer;
    }
    static void binarySearch(int[] times, int n) {

        while(min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for(int time : times) {
                sum += (mid / (long)time);
                if(sum > n) {
                    break;
                }
            }
            if(sum >= n) {
                if(answer > mid) {
                    answer = mid;
                }
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
    }
}
