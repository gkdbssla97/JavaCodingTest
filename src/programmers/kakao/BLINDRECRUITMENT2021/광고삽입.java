package programmers.kakao.BLINDRECRUITMENT2021;

import java.util.*;

public class 광고삽입 {
    public static String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;
        int playtime = strToInt(play_time);
        int advtime = strToInt(adv_time);
        int[] sum = new int[playtime + 1];

        for (String log : logs) {
            String[] split = log.split("-");
            int start = strToInt(split[0]);
            int end = strToInt(split[1]);

            sum[start]++;
            sum[end]--;
        }
        // 누적합 연산
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }

        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }

        long maxRet = sum[advtime - 1];
        int maxStartTime = 0;
        for (int i = advtime; i < sum.length; i++) {
            if (maxRet < sum[i] - sum[i - advtime]) {
                maxRet = sum[i] - sum[i - advtime];
                maxStartTime = i - advtime + 1;
            }
        }
//        long max = 0;
//        for (int i = 1; i < advtime; i++) {
//            max += sum[i];
//        }
//        long now = max;
//        for (int i = 0, j = advtime; j < playtime; i++, j++) {
//            now = now - sum[i] + sum[j];
//            if (now > max) {
//                answer = i + 1;
//                max = now;
//            }
//        }
        return String.format("%02d:%02d:%02d", maxStartTime / (60 * 60),
                (maxStartTime / 60) % 3600, maxStartTime % 60);
    }

    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        solution(play_time, adv_time, logs);
    }

    public static int strToInt(String time_str) {
        String[] arr = time_str.split(":");
        int time = Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60
                + Integer.parseInt(arr[2]);
        return time;
    }
}
