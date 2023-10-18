package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ21921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int[] board = new int[n];
        int[] prefix = new int[n + 1];
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);
        }
        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + board[i];
        }
        int res = 0;
        for(int i = x; i <= n; i++) {
            int v = prefix[i] - prefix[i - x];
            res = Math.max(res, v);
        }
        int cnt = 0;
        for(int i = x; i <= n; i++) {
            if(res == prefix[i] - prefix[i - x]) cnt++;

        }
        if(res == 0) System.out.println("SAD");
        else {
            System.out.println(res);
            System.out.println(cnt);
        }
    }
}
