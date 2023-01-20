package programmers.kakao;

import java.util.*;

public class 주차요금계산 {
    static class Parking {
        List<String> time = new ArrayList<>();
        int car_num;
        int result_fee = 0;

        public Parking(String time, int car_num) {
            this.time.add(time);
            this.car_num = car_num;
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        List<Parking> parkingList = new ArrayList<>();
        for (String s : records) {
            String[] info = s.split(" ");
            if (parkingList.stream().anyMatch(x -> x.car_num == Integer.parseInt(info[1]))) {
                Parking parking = parkingList.stream().filter(x -> x.car_num == Integer.parseInt(info[1])).findFirst().get();
                parking.time.add(info[0]);
            } else {
                parkingList.add(new Parking(info[0], Integer.parseInt(info[1])));
            }
        }

        for (Parking x : parkingList) {
            if (x.time.size() % 2 != 0) {
                x.time.add("23:59");
            }
        }

        for (Parking x : parkingList) {
            int out, in;
            int total = 0;
            for (int i = 0; i < x.time.size(); i += 2) {
                String[] split1 = x.time.get(i).split(":");
                String[] split2 = x.time.get(i + 1).split(":");

                out = Integer.parseInt(split2[0]) * 60 + Integer.parseInt(split2[1]);
                in = Integer.parseInt(split1[0]) * 60 + Integer.parseInt(split1[1]);

                total += out - in;
            }
            if (total <= fees[0]) {
                x.result_fee = fees[1];
            } else {
                total -= fees[0];
                x.result_fee += fees[1];
//                System.out.println(Math.ceil((double)total / fees[2]));
                double v = Math.ceil((double)total / fees[2]) * fees[3];
                x.result_fee += (int) v;
            }
        }
        Collections.sort(parkingList, new Comparator<Parking>() {
            @Override
            public int compare(Parking o1, Parking o2) {
                return o1.car_num - o2.car_num;
            }
        });
        List<Integer> answer = new ArrayList<>();
        for (Parking p : parkingList) {
//            System.out.println(p.car_num);
            answer.add(p.result_fee);
        }
        int[] ints = answer.stream().mapToInt(x -> x).toArray();
        for (int x : ints) {
            System.out.print(x + " ");
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT",
                "22:59 5961 IN", "23:00 5961 OUT"};
        // result = [14600, 34400, 5000]
        solution(fees, records);
    }
}
