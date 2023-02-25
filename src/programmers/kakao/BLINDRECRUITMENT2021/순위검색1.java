package programmers.kakao.BLINDRECRUITMENT2021;

import java.util.*;
import java.util.stream.Collectors;

public class 순위검색1 {
    static HashMap<String, List<Integer>> map;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0);
        }
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
//        System.out.println(map + " ");
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
//            System.out.println(query[i]);
            String[] q = query[i].split(" ");
            if (map.containsKey(q[0])) {
                answer[i] = binarySearch(q[0], Integer.parseInt(q[1]));
            } else answer[i] = 0;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return list.size() - start;
    }

    static void makeSentence(String[] p, String str, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeSentence(p, str + "-", cnt + 1);
        makeSentence(p, str + p[cnt], cnt + 1);
    }

    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        solution(info, query);
    }

}
