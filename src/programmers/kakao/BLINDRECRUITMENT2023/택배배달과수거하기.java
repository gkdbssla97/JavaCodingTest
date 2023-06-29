package programmers.kakao.BLINDRECRUITMENT2023;

import java.util.*;

//230629 16:24
class 택배배달과수거하기 {
    static Stack<Village> del = new Stack<>();
    static Stack<Village> pick = new Stack<>();
    static long res = 0;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;

        for(int i = 0; i < deliveries.length; i++) {
            long d = deliveries[i];
            long p = pickups[i];
            if(d != 0) {
                del.push(new Village(d, i + 1));
            }
            if(p != 0) {
                pick.push(new Village(p, i + 1));
            }
        }
        // print(del);
        // print(pick);
        // 스택이 둘다 빌 때 까지
        while(!del.isEmpty() || !pick.isEmpty()) {
            // 배달
            long tmp_d = 0;
            long tmp_p = 0;
            boolean flag = false;
            long d_cap = 0;
            while(!del.isEmpty()) {
                Village cur = del.peek();
                if(cap >= d_cap + cur.things) {
                    d_cap += cur.things;
                    Village _cur = del.pop();
                    if(tmp_d == 0) {
                        tmp_d = _cur.v_num;
                    }
                } else {
                    flag = true;
                    Village p = del.pop();
                    del.push(new Village(p.things - (cap - d_cap), p.v_num));
                    if(tmp_d == 0) {
                        tmp_d = p.v_num;
                    }
                }
                // System.out.println(1);
                if(flag) {
                    break;
                }
            }
            // 수거
            flag = false;
            long p_cap = 0;
            while(!pick.isEmpty()) {
                Village cur = pick.peek();
                if(cap >= p_cap + cur.things) {
                    p_cap += cur.things;
                    Village _cur = pick.pop();
                    if(tmp_p == 0) {
                        tmp_p = _cur.v_num;
                    }
                } else {
                    flag = true;
                    Village p = pick.pop();
                    pick.push(new Village(p.things - (cap - p_cap), p.v_num));
                    if(tmp_p == 0) {
                        tmp_p = p.v_num;
                    }
                }

                if(flag) {
                    break;
                }
            }
            // System.out.println(tmp_d + " " + tmp_p);
            res += Math.max(tmp_d, tmp_p);
        }
        return res * 2;
    }

    static class Village {
        long things, v_num;

        Village(long things, long v_num) {
            this.things = things;
            this.v_num = v_num;
        }
    }

    static void print(Stack<Village> s) {
        while(!s.isEmpty()) {
            Village z = s.pop();
            System.out.print(z.things + " " + z.v_num);
        }
    }
}
