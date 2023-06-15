package programmers.kakao.BLINDRECRUITMENT2023;

import java.util.Stack;

public class 택배배달과수거하기 {
    static Stack<Logis> delivery;
    static Stack<Logis> pickup;
    static long res = 0;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        delivery = new Stack<>();
        pickup = new Stack<>();

        long index = 1;
        // 배달
        for (int d : deliveries) {
            if (d != 0) {
                delivery.push(new Logis(index, d));
            }
            index++;
        }
        index = 1;
        // 수거
        for (int p : pickups) {
            if (p != 0) {
                pickup.push(new Logis(index, p));
            }
            index++;
        }

        while (!delivery.isEmpty() || !pickup.isEmpty()) {
            long c = 0;
            long tmp_d = 0;
            long tmp_p = 0;
            while (!delivery.isEmpty()) {
                // 1. 배달
                Logis d = delivery.pop();

                if (tmp_d == 0) {
                    tmp_d = d.home;
                }

                if (cap < c + d.val) {
                    // System.out.println("-> " + d.val);
                    delivery.push(new Logis(d.home, c + d.val - cap));
                    c = cap;
                    break;
                }
                c += d.val;

                // 2. 수거
                if (c == cap) {
                    break;
                }
            }
            // System.out.println(delivery.peek().home + " " + delivery.peek().val);

            // System.out.println(tmp);
            long _c = 0;
            while (!pickup.isEmpty()) {
                Logis p = pickup.pop();

                if (tmp_p == 0) {
                    tmp_p = p.home;
                }

                if (_c + p.val > cap) {
                    pickup.push(new Logis(p.home, _c + p.val - cap));
                    break;
                }
                _c += p.val;
                if (cap == _c) {
                    break;
                }
            }
            // System.out.println(pickup.peek().home + " " + pickup.peek().val);
            res += (2 * Math.max(tmp_d, tmp_p));
        }

        long answer = -1;
        return res;
    }

    static class Logis {
        long home, val;

        Logis(long home, long val) {
            this.home = home;
            this.val = val;
        }
    }
}
