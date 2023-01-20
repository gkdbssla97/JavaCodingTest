package programmers.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 개인정보수집유효기간 {

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length + 1];

        String[] split1 = today.split("\\.");
        int y1 = Integer.parseInt(split1[0]) * 28 * 12;
        int m1 = Integer.parseInt(split1[1]) * 28;
        int d1 = Integer.parseInt(split1[2]);
        int today_total = y1 + m1 + d1 + 1;

        HashMap<String, Integer> hashMap = new HashMap<>(3);
        for (String x : terms) {
            String[] s = x.split(" ");
            hashMap.put(s[0], Integer.parseInt(s[1]));
        }
        int idx = 1;
        for (String x : privacies) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (String.valueOf(x.charAt(11)).equals(entry.getKey())) {
                    extracted(answer, today_total, hashMap, idx, x, entry.getValue());
                }
            }idx++;
        }
        int[] ints = Arrays.stream(answer).filter(x -> x > 0).toArray();
        return answer;
    }

    private static void extracted(int[] answer, int today_total, HashMap<String, Integer> hashMap, int idx, String x, int value) {
        String substring = x.substring(0, 10);
        String[] split = substring.split("\\.");
        int y = Integer.parseInt(split[0]) * 28 * 12;
        int m = Integer.parseInt(split[1]) * 28;
        int d = Integer.parseInt(split[2]);
        int future_total = y + m + d + (28 * value);
        if (today_total > future_total) {
            answer[idx] = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

//        String today = "2020.01.01";
//        String[] terms = {"Z 3", "D 5"};
//        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int[] answer = solution(today, terms, privacies);
        for (int x : answer) {
            if (x > 0) {
                System.out.print(x + " ");
            }
        }
        // A = 6달 B = 12달 C = 3달


    }
}
