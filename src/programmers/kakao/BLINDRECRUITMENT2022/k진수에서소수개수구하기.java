package programmers.kakao.BLINDRECRUITMENT2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class k진수에서소수개수구하기 {
    public static int solution(int n, int k) {
        int answer = 0;

        List<String> parsingString = cal(n, k);
        String tmp = "";
        for (int i = 0; i < parsingString.size(); i++) {
            if (!parsingString.get(i).equals("0")) {
                tmp += parsingString.get(i);
            } else {
                if(tmp.equals("")) continue;
                else if (isPrime(Long.parseLong(tmp)) && !tmp.equals("1")) {
                    answer++;
                }
                tmp = "";
            }
        } if(!tmp.equals("")) {
            if (isPrime(Long.parseLong(tmp)) && !tmp.equals("1")) answer++;
        }
        System.out.println(answer);
        return answer;
    }

    static boolean isPrime(long n) {
        for (long i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static List<String> cal(long n, long k) {
        //153을 2진법으로
        ArrayList<String> list = new ArrayList<>();
        while (n != 0) {
            list.add(String.valueOf(n % k));
            n /= k;
        }
        Collections.reverse(list);
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        int n = 36;
        int k = 3;
//        int n = 1;
//        int k = 10;

        System.out.println(solution(n, k));
    }
}
