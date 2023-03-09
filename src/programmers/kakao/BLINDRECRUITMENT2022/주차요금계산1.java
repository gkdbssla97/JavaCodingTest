package programmers.kakao.BLINDRECRUITMENT2022;

import java.util.*;
import java.util.stream.Collectors;

public class 주차요금계산1 {
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, ArrayList<Integer>> carInfo = new LinkedHashMap<>();
        HashMap<String, Integer> carRes = new LinkedHashMap<>();

        for (String record : records) {
            String[] info = record.split(" ");

            String time = info[0];
            String carNum = info[1];

            ArrayList<Integer> arr = carInfo.getOrDefault(carNum, new ArrayList<>());
            arr.add(parsingTime(time));
            carInfo.put(carNum, arr);
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : carInfo.entrySet()) {
            if (entry.getValue().size() % 2 != 0) {
                ArrayList<Integer> value = entry.getValue();
                value.add(parsingTime("23:59"));
                carInfo.put(entry.getKey(), value);
            }
            carRes.put(entry.getKey(), 0);
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : carInfo.entrySet()) {
            ArrayList<Integer> value = entry.getValue();
            int subTime = 0;
            for (int i = 0; i < value.size() - 1; i+= 2) {
                subTime += value.get(i + 1) - value.get(i);
                if (subTime <= fees[0]) {
                    carRes.put(entry.getKey(), fees[1]);
                } else {
                    int total = fees[1] + (int)Math.ceil((double)(subTime - fees[0]) / fees[2]) * fees[3];
                    carRes.put(entry.getKey(), total);
                }
            }
        }
        List<String> res = new ArrayList<>(carRes.keySet());
        res.sort(String::compareTo);
        ArrayList<Integer> money = new ArrayList<>();
        for (String key : res) {
            money.add(carRes.get(key));
        }
        return money.stream().mapToInt(x ->x).toArray();
    }
    static int parsingTime(String time) {
        String[] split = time.split(":");
        return (Integer.parseInt(split[0])) * 60 + (Integer.parseInt(split[1]));
    }
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN",
                "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN",
                "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
