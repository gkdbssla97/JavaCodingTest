package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ12919 {
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String _s = br.readLine();
        String _t = br.readLine();
        StringBuilder s = new StringBuilder(_s);
        StringBuilder t = new StringBuilder(_t);
        flag = false;
        if(s.length() <= t.length()) {
            dfs(s, t);
            if(flag) System.out.println(1);
            else System.out.println(0);


        } else System.out.println(0);
    }
    static void dfs(StringBuilder s, StringBuilder t) {
//        System.out.println(s + " " + t);
        if(s.length() == t.length() && s.toString().equals(t.toString())) {
//            System.out.println("hi");
            flag = true;
            return;
        } else if(s.length() == t.length()) return;

        int ans = 0;
        StringBuilder tmp;
        if(t.charAt(t.length() - 1) == 'A') {
            tmp = new StringBuilder(t);
            dfs(s, tmp.deleteCharAt(tmp.length() - 1));
        }
        if(t.charAt(0) == 'B') {
            tmp = new StringBuilder(t);
            tmp = new StringBuilder(tmp.substring(1));
            tmp.reverse();
            dfs(s, tmp);
        }
    }
}
