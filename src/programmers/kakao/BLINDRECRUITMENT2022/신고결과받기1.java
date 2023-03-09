package programmers.kakao.BLINDRECRUITMENT2022;

import java.util.*;
import java.util.stream.Collectors;

public class 신고결과받기1 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();

        for (String rep : report) {
            String[] s = rep.split(" ");
            Set<String> set = map.getOrDefault(s[1], new HashSet<>());
            set.add(s[0]);
            map.put(s[1], set);
        }
        Map<String, Integer> countMap = new LinkedHashMap<>();
        for (String id : id_list) {
            countMap.put(id, 0);
        }
        for (Map.Entry<String, Set<String>> array : map.entrySet()) {
            if (array.getValue().size() >= k) {
                for (String s : array.getValue()) {
                    countMap.put(s, countMap.getOrDefault(s, 0) + 1);
                }
            }
        }
        return countMap.values().stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));

    }
}
