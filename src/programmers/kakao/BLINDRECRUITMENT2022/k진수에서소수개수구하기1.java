package programmers.kakao.BLINDRECRUITMENT2022;

import static java.lang.Long.toUnsignedString;

public class k진수에서소수개수구하기1 {
    public static int solution(int n, int k) {
        int answer = 0;
        String[] split = toUnsignedString(n, k).replaceAll("[0]+", "0").split("0");
        for (String str : split) {
            if(isPrime(Long.parseLong(str))) {
                answer++;
            }
        }
        return answer;
    }

    static boolean isPrime(long number) {
        if(number < 2) return false;
        if(number == 2) return true;
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        int k = 2;
//        int n = 1;
//        int k = 10;

        System.out.println(solution(n, k));
    }
}
