package programmers.kakao.BLINDRECRUITMENT2023;

import java.util.*;
import java.io.*;

class 표현가능한이진트리 {
    static ArrayList<Integer> arr = new ArrayList<>();
    public ArrayList<Integer> solution(long[] numbers) {

        boolean[] answer = new boolean[numbers.length];
        int idx = 0;
        for(long number : numbers) {
            StringBuilder s = _Binary(number);
            if(number == 1) {
                arr.add(1);
                continue;
            }
            boolean flag = false;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    flag = true;
                }
            }
            if(!flag) {
                arr.add(1);
                continue;
            }
            // System.out.println(s);
            int len = s.length();
            int h = 0;
            StringBuilder tmp = new StringBuilder();
            while(len > Math.pow(2, h) - 1) {
                h++;
            }
            while(len != (int)Math.pow(2, h) - 1) {
                tmp.append("0");
                len++;
            }
            tmp.append(s);
            if(dfs(tmp.toString())) {
                arr.add(1);
            } else {
                arr.add(0);
            }
        }
        return arr;
    }
    static boolean dfs(String s) {
        boolean flag = true;
        int len = s.length();
        int mid = len / 2;

        char mid_s = s.charAt(len / 2); // 1
        String left_s = s.substring(0, mid); // 010
        String right_s = s.substring(mid + 1); // 010

        if(mid_s == '0' && (left_s.charAt(left_s.length() / 2) == '1'||
                right_s.charAt(right_s.length() / 2) == '1')) {
            return false;
        }
        if(left_s.length() >= 3) {
            flag = dfs(left_s);
            if(flag) {
                flag = dfs(right_s);
            }
        }
        return flag;
    }
    static StringBuilder _Binary(long number) {
        StringBuilder sb = new StringBuilder();
        while(number != 0) {
            if(number % 2 == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            number /= 2;
        }
        return sb.reverse();
        // return sb.toString();
    }
}
/**
 1. 2^h-1개 만큼 왼쪽부터 '0'만큼 갯수 채우기
 2. len == 3일때 이진트리 여부 확인가능
 2-1. len >=3 이면 계속 dfs 돌리기
 3. root 노드, left, right 루트노드 값 확인

 왼/우측 루트노드 찾아가면서 boolean 확인하는 재귀함수
 **/

