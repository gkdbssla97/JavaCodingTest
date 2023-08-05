package baekjoon.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //window sliding?
        int n = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        int ans = 0;
//        System.out.println(sb.toString());
        for(int i = 0; i < len - 2; i++) {
            if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'O'
        && s.charAt(i + 2) == 'I') {
                cnt++;
                i++;
                if(cnt == n) {
                    ans++;
                    cnt--;
                }
            } else {
                cnt = 0;
            }
        }
        System.out.println(ans);
    }
}
