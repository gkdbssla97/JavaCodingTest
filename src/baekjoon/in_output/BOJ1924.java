package baekjoon.in_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1924 {
    enum month {
        JAN(1, 31),
        FEB(2, 28),
        MAR(3, 31),
        APRIL(4, 30),
        MAY(5, 31),
        JUNE(6, 30),
        JULY(7, 31),
        AUG(8, 31),
        SEP(9, 30),
        OCT(10, 31),
        NOV(11, 30),
        DEC(12, 31);

        private int first;
        private int last;

        month(int first, int last) {
            this.first = first;
            this.last = last;
        }

        public int getFirst() {
            return first;
        }

        public int getLast() {
            return last;
        }

        static Integer findsFirstByMonth(int month) {
            return Arrays.stream(BOJ1924.month.values())
                    .map(BOJ1924.month::getFirst)
                    .filter(x -> x.equals(month))
                    .findFirst().orElse(null);
        }

        static Integer findsLastByMonth(int month) {
            return Arrays.stream(BOJ1924.month.values())
                    .filter(x -> x.getFirst() == month)
                    .map(BOJ1924.month::getLast)
                    .findFirst().orElse(null);
        }
    }

    static int[] day = new int[366];
    static List<String> ans = new ArrayList<>() {
        {
            add("SUN");
            add("MON");
            add("TUE");
            add("WED");
            add("THU");
            add("FRI");
            add("SAT");
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int total = 0;
        for (int i = 1; i < month; i++) {
            total += BOJ1924.month.findsLastByMonth(i);
        }
        total += day;
        System.out.println(ans.get(total % 7));

    }
}
