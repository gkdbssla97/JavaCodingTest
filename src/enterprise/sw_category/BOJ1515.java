package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1515 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int idx = 0;
        for (int i = 1;; i++) {
            String str = String.valueOf(i);
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == s.charAt(idx)) {
                    idx++;
                }
                if(idx == s.length()) {
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }
    }
}
