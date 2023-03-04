package programmers.summerwintercoding;

import java.math.BigInteger;

public class 멀쩡한사각형 {
    public static long solution(int w, int h) {
        long answer = 1;
        BigInteger wi = BigInteger.valueOf(w);
        BigInteger hi = BigInteger.valueOf(h);
        BigInteger gcd = wi.gcd(hi);
//        System.out.println(gcd);
        return (long)w * (long)h - ((long) (wi.intValue()/ gcd.intValue()) + (hi.intValue()/ gcd.intValue() - 1));
    }
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        solution(w, h);
    }
}
