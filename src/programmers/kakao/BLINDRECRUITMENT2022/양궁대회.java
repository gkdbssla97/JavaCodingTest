package programmers.kakao.BLINDRECRUITMENT2022;

import java.util.Arrays;

public class 양궁대회 {
    static int[] score = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int res_max = 0;
    static int[] res_ryan = new int[11];

    public static int[] solution(int n, int[] info) {
        int[] res = new int[n];

        combination_with_repetition(info, n, res, 0, 0);
        if(res_max == 0) return new int[]{-1};
        return res_ryan;
    }

    static void combination_with_repetition(int[] info, int r, int[] tmp, int cur, int start) {
        if (r == cur) {
            int[] copy_info = info.clone();
            int[] ryan_info = new int[11];
            for (int e : tmp) {
                ryan_info[10 - e] += 1;
            }

            int ryan = 0;
            int apeach = 0;
            for (int i = 0; i < 11; i++) {
                if (copy_info[i] == 0 && ryan_info[i] == 0) continue;
                else {
                    if (copy_info[i] >= ryan_info[i]) {
                        apeach += 10 - i;
                    } else ryan += 10 - i;
                }
            }

            boolean isLarge = false;
            if (res_max == ryan - apeach) {
                for (int i = 10; i >= 0; i--) {
                    if (ryan_info[i] == res_ryan[i])
                        continue;
                    else if (ryan_info[i] > res_ryan[i]) {
                        isLarge = true;
                        break;
                    } else break;
                }
                if(isLarge) res_ryan = ryan_info.clone();
            } else if (res_max < ryan - apeach) {
                res_max = ryan - apeach;
                res_ryan = ryan_info.clone();
            }
        } else {
            for (int i = start; i < score.length; i++) {
                tmp[cur] = score[i];
                combination_with_repetition(info, r, tmp, cur + 1, i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        solution(n, info);
        System.out.println(Arrays.toString(res_ryan));
    }
}