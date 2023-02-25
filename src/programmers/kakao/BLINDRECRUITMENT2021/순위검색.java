package programmers.kakao.BLINDRECRUITMENT2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 순위검색 {
    public static Integer[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            board.add(new ArrayList<>());
        }
        for (String q : query) {
            int cnt = 0;
            String replace = q.replace(" and ", " ");
            List<String> collect1 = Arrays.stream(replace.split(" ")).collect(Collectors.toList());
            for (int i = 0; i < info.length; i++) {
                List<String> collect2 = Arrays.stream(info[i].split(" ")).collect(Collectors.toList());
                if (extracted(collect1, collect2))
                    cnt++;
            }
            answer.add(cnt);
        }
        System.out.println(answer);
        return answer.toArray(new Integer[0]);
    }

    private static boolean extracted(List<String> collect1, List<String> collect2) {
        return (collect1.get(0).equals(collect2.get(0)) || collect1.get(0).equals("-")) &&
                (collect1.get(1).equals(collect2.get(1)) || collect1.get(1).equals("-")) &&
                (collect1.get(2).equals(collect2.get(2)) || collect1.get(2).equals("-")) &&
                (collect1.get(3).equals(collect2.get(3)) || collect1.get(3).equals("-")) &&
                Integer.parseInt(collect1.get(4)) <= Integer.parseInt(collect2.get(4));
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
