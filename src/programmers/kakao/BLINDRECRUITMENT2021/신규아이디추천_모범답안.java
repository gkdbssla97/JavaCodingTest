package programmers.kakao.BLINDRECRUITMENT2021;

import java.util.Arrays;

public class 신규아이디추천_모범답안 {
    public static String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
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
