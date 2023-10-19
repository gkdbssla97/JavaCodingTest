package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BOJ2607 {
    static HashMap<Character, Integer> map1 = new LinkedHashMap<>();
    static HashMap<Character, Integer> map2;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String target = br.readLine();
        int res = 0;
        for(int i = 0; i < n - 1; i++) {
            String s = br.readLine();
            int[] board = new int[26];
            int cnt = 0;
            for(int j = 0; j < target.length(); j++) {
                board[target.charAt(j) - 'A']++;
            }

            for(int j = 0; j < s.length(); j++) {
                if(board[s.charAt(j) - 'A'] > 0) {
                    board[s.charAt(j) - 'A']--;
                    cnt++;
                }
            }

            if(s.length() == target.length() && cnt == target.length()) { // 같은 구성
                res++;
            } else if(s.length() == target.length() && cnt == target.length() - 1) { // 교체
                res++;
            } else if(s.length() == target.length() - 1 && cnt == target.length() - 1) { // 빼기
                res++;
            } else if(s.length() == target.length() + 1 && cnt == target.length()) { // 더하기
                res++;
            }
        }
        System.out.println(res);
    }
}
