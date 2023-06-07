package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1522 {
    static String input;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        int min = Integer.MAX_VALUE;
        int aCnt = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'a') {
                aCnt++;
            }
        }

        for(int i = 0; i < input.length(); i++) {
            int bCnt = 0;
            for(int j = i; j < i + aCnt; j++) {
                int idx = j % input.length();
                if(input.charAt(idx) == 'b') {
                    bCnt++;
                }
            }
            if(min >= bCnt) {
                min = bCnt;
            }
        }
        System.out.println(min);
    }
}
