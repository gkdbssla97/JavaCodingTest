package programmers.kakao.BLINDRECRUITMENT2021;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 메뉴리뉴얼 {
    static HashMap<String, Integer> board;

    public static List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        board = new HashMap<>();
        for (String str : orders) {
            str = Stream.of(str.split(""))
                    .sorted()
                    .collect(Collectors.joining());
            answer.add(str);
        }
        orders = answer.toArray(orders);
        for (int r : course) {
            for (String order : orders) {
                boolean[] visited = new boolean[order.length()];
                String[] split = order.split("");
                if (order.length() < r) continue;
                combination(split, visited, 0, split.length, r);
            }
        }

        for (Map.Entry<String, Integer> entry : board.entrySet()) {
            for (String order : orders) {
                String key = entry.getKey();
                String[] split = key.split("");
                boolean flag = false;
                for (String s : split) {
                    if (order.contains(s))
                        continue;
                    else flag = true;
                }
                if (!flag) entry.setValue(entry.getValue() + 1);
            }
        }
//        for(Map.Entry<String, Integer> entry: board.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(board.entrySet());

        List<String> ans = new ArrayList<>();

        for (int r : course) {
            List<Map.Entry<String, Integer>> collect = entryList.stream().filter(x -> x.getKey().length() == r).collect(Collectors.toList());
            if (collect.size() == 0) continue;
            Collections.sort(collect, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            int max_length = collect.get(0).getValue();
            for (int i = 0; i < collect.size(); i++) {
                if (max_length == collect.get(i).getValue() && max_length != 1)
                    ans.add(collect.get(i).getKey());
            }
//            for (Map.Entry<String, Integer> entry : collect) {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            }
        }
        Collections.sort(ans);
        for (String s : ans) {
            System.out.println(s);
        }
        return ans;
    }

    public static void combination(String[] orders, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            String tmp = "";
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    tmp += orders[i];
            }
            board.put(tmp, 0);
            return;
        }
        if (depth == n)
            return;

        visited[depth] = true;
        combination(orders, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        combination(orders, visited, depth + 1, n, r);

    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
//        int[] course = {2, 3, 5};
//        int[] course = {2, 3, 4};
        solution(orders, course);
    }
}
