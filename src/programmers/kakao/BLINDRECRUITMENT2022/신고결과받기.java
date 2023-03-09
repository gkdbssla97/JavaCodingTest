package programmers.kakao.BLINDRECRUITMENT2022;

import java.util.*;

public class 신고결과받기 {
    static HashMap<String, ArrayList<String>> reportList; //신고기록
    static HashMap<String, Integer> reportedMan; //신고당한사람
    static HashMap<String, Integer> list; //신고한사람

    public static int[] solution(String[] id_list, String[] report, int k) {
        reportList = new HashMap<>();
        reportedMan = new HashMap<>();
        list = new LinkedHashMap<>();

        for (String person : id_list) {
            reportedMan.put(person, 0);
            list.put(person, 0);
        }

        for (String report_list : report) {

            String[] s = report_list.split(" ");
            String reporting = s[0];
            String reported = s[1];
            if (reportList.containsKey(reporting)) {
                ArrayList<String> strings = reportList.get(reporting);
                if (strings.contains(reported)) {
                    continue;
                } else {
                    strings.add(reported);
                    reportList.put(reporting, strings);
                    reportedMan.put(reported, reportedMan.getOrDefault(reported, 0) + 1);
                }
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(reported);
                reportList.put(reporting, list);
                reportedMan.put(reported, reportedMan.getOrDefault(reported, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry1 : reportedMan.entrySet()) {
            if (entry1.getValue() >= k) {
                String key = entry1.getKey();
                for (Map.Entry<String, ArrayList<String>> entry2 : reportList.entrySet()) {
                    if (entry2.getValue().contains(key)) {
                        list.put(entry2.getKey(), list.getOrDefault(entry2.getKey(), 0) + 1);
                    }
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            answer.add(entry.getValue());
        }



        return answer.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));

    }
}
