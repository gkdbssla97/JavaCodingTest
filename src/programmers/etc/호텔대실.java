package programmers.etc;

import java.util.*;

public class 호텔대실 {
    static class Hotel {
        int start, end;

        public Hotel(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static List<Hotel> board;

    static String parsing(String s) {
        return s.replace(":", "");
    }
    static int toMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

    }
    public static int solution(String[][] book_time) {
        int answer = 1;


        board = new ArrayList<>();
        for (String[] book : book_time) {
            board.add(new Hotel(toMinute(book[0]), toMinute(book[1])));
        }

        board.sort(new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

//        for (int i = 0; i < book_time.length; i++)
//            System.out.println(board.get(i).start + " " + board.get(i).end);

        List<Integer> endTimeList = new ArrayList<>();

        for (Hotel hotel : board) {
            boolean isBookedOnSame = false;
            Collections.sort(endTimeList);
            System.out.println(endTimeList.toString());
            for (int i = 0; i < endTimeList.size(); i++) {
                int endTime = endTimeList.get(i) + 10;
                if (hotel.start >= endTime) {
                    endTimeList.set(i, hotel.end);
                    isBookedOnSame = true;
                    break;
                }
            }
            if(!isBookedOnSame) endTimeList.add(hotel.end);
        }
        return endTimeList.size();
    }

    public static void main(String[] args) {
        String[][] book_time = {{"15:30", "16:20"}, {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(book_time));
    }
}
