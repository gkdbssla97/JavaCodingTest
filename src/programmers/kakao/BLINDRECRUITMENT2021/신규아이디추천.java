package programmers.kakao.BLINDRECRUITMENT2021;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 신규아이디추천 {
    public static String solution(String new_id) {
        String answer = "";

        // 1단계
        String[] split = new_id.toLowerCase().split("");

        System.out.println("1단계: " + Arrays.toString(split));
        // 2단계
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("-") || split[i].equals("_")
                    || split[i].equals(".") || split[i].matches("^[a-zA-Z0-9]*$")) {
                continue;
            } else split[i] = "";
        }
        System.out.println("2단계: " + Arrays.toString(split));

        // 3단계
        boolean flag = false;
        for (int i = 0; i < split.length; i++) {
            if(flag && (split[i].equals(".") || split[i].equals(""))) {
                split[i] = "";
                continue;
            }
            if(split[i].equals(".")) {
                flag = true;
            } else {
                flag = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("")) {
                continue;
            } sb.append(split[i]);
        }
        System.out.println("3단계 : " + sb);
        // 4단계
        if(sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        } if(sb.length() != 0) {
            if (sb.charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println("4단계 : " + sb);
        // 5단계
        if(sb.length() == 0) sb.append("a");
//        System.out.println("5단계 : " + sb);
        // 6단계
        String sub = "";
        if(sb.length() >= 16) {
            sub = sb.substring(0, 15);
        } else sub = sb.toString();

        if(sub.charAt(sub.length() - 1) == '.')
            sub = sub.substring(0, sub.length() - 1);

        //7단계
        StringBuilder last = new StringBuilder(sub);
        if (last.length() <= 2) {
            while(last.length() != 3) {
                last.append(sub.charAt(sub.length() - 1));
            }
        }
//        System.out.println(last);
        System.out.println("6단계 : " + last);


        return last.toString();
    }

    public static void main(String[] args) {
//        String new_id = "...!@BaT#*..y.abcdefghijklm";
//        String new_id = "z-+.^.";
//        String new_id = "=.=";
//        String new_id = "123_.def";
        String new_id = "abcdefghijklmn.p";
        solution(new_id);
    }
}
