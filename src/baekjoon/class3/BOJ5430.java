package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String _cmd = br.readLine();
//            _cmd = _cmd.replaceAll("RR", " ");
//            _cmd = _cmd.replaceAll(" ", "");
            String[] cmd = _cmd.split("");
            int p = Integer.parseInt(br.readLine());
            Deque<Integer> dq = parsing(br.readLine());
//            System.out.println("parsing -> " + dq);
            boolean flag = false;
            boolean isLeft = true;
            for (int j = 0; j < cmd.length; j++) {
                if (cmd[j].equals("R")) {
                    isLeft = !isLeft;
                } else {
                    if(dq.size() == 0) {
                        System.out.println("error");
                        flag = true;
                        break;
                    } else {
                        if(isLeft) {
                            dq.poll();
                        } else dq.pollLast();
                    }
                }
//                System.out.println("p ->" + p + " " +parsing);
            }
            if(!flag) System.out.println(re_parsing(dq, isLeft));
        }
    }

    static Deque<Integer> parsing(String s) {
        Deque<Integer> dq = new ArrayDeque<>();
        int tmp = -1;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                if(tmp > 0) {
                    tmp = (s.charAt(i) - '0') + tmp * 10;
                } else {
                    tmp = (s.charAt(i) - '0');
                }
            } else {
                if(tmp > 0) {
                    dq.offer(tmp);
                    tmp = 0;
                }
            }
        }
        return dq;
    }
    static String re_parsing(Deque<Integer> dq, boolean isLeft) {
        StringBuilder n = new StringBuilder();

        n.append("[");
        if(dq.size() == 0) {
            n.append("]");
            return n.toString();
        }
        while(!dq.isEmpty()) {
            int p = -1;
            if(isLeft) {
                p = dq.poll();
            } else p = dq.pollLast();
            n.append(p);
            n.append(",");
        }
        n.deleteCharAt(n.length() - 1);
//        if(n.length() != 0) {
            n.append("]");
//        }
        return n.toString();
    }
}
