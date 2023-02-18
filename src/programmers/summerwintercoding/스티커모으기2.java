package programmers.summerwintercoding;

import java.util.Arrays;

public class 스티커모으기2 {
    static boolean[] visited;
    static int max_val = 0;

    public static int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;

        if(len == 1) return sticker[0];
        int [] dpFirst = new int[len];
        int [] dpSecond = new int[len];

        // 첫 번째 스티커
        dpFirst[0] = sticker[0];
        dpFirst[1] = sticker[0];

        // 두 번째 스티커
        dpSecond[0] = 0;
        dpSecond[1] = sticker[1];

        for (int i = 2; i < len; i++) {
            dpFirst[i] = Math.max(dpFirst[i - 1], dpFirst[i - 2] + sticker[i]);
            dpSecond[i] = Math.max(dpSecond[i - 1], dpSecond[i - 2] + sticker[i]);
        }

        return Math.max(dpFirst[len - 2], dpSecond[len - 1]);
    }

    public static void main(String[] args) {
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(solution(sticker));
    }
}
