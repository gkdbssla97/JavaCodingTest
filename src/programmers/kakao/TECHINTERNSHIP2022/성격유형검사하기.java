package programmers.kakao.TECHINTERNSHIP2022;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    static HashMap<Integer, String> map;
    static HashMap<String, Integer> result;

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        initResult();
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] == 4)
                continue;
            else if (choices[i] <= 3) {
                String key = String.valueOf(survey[i].charAt(0));
                result.put(key, result.get(key) + score[choices[i]]);
            } else {
                String key = String.valueOf(survey[i].charAt(1));
                result.put(key, result.get(key) + score[choices[i]]);
            }
        }
        // RT
        Integer R = result.get("R");
        Integer T = result.get("T");
        if (R >= T) answer += "R";
        else answer += "T";

        // CF
        Integer C = result.get("C");
        Integer F = result.get("F");
        if (C >= F) answer += "C";
        else answer += "F";

        // JM
        Integer J = result.get("J");
        Integer M = result.get("M");
        if (J >= M) answer += "J";
        else answer += "M";

        // AN
        Integer A = result.get("A");
        Integer N = result.get("N");
        if (A >= N) answer += "A";
        else answer += "N";

        System.out.println(answer);
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return answer;
    }

    private static void initResult() {
        result = new HashMap<>(8);
        result.put("R", 0); result.put("T", 0);
        result.put("C", 0); result.put("F", 0);
        result.put("J", 0); result.put("M", 0);
        result.put("A", 0); result.put("N", 0);
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        solution(survey, choices);
    }
}
