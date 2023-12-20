package baekjoon.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            String s = br.readLine();
            if(s.equals("0")) break;
            int len = s.length();
            boolean flag = true;
            //홀수
            if (len % 2 != 0) {
                for(int i = 0; i < len / 2; i++) {
                    if(s.charAt(i) == s.charAt(len - i - 1)) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            //짝수
            else {
                for(int i = 0; i < len / 2; i++) {
                    if(s.charAt(i) == s.charAt(len - i - 1)) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                System.out.println("yes");
            } else System.out.println("no");
        }
    }
}
