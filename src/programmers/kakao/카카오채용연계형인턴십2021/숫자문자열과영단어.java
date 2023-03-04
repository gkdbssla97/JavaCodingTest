package programmers.kakao.카카오채용연계형인턴십2021;

public class 숫자문자열과영단어 {
    public static int solution(String s) {
        String[] numberCase = {"zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine"};

        int answer = 0;
        for(int i = 0; i < numberCase.length; i++) {
            if (s.contains(numberCase[i])) {
                s = s.replaceAll(numberCase[i], String.valueOf(i));
            }
        }
        System.out.println(s);
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String a = "one4seveneight";//	1478
        String b = "23four5six7";//	234567
        String c = "2three45sixseven";//	234567
        String d = "123";//	123

        solution(a);
    }
}
