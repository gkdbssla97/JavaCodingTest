package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        long[] board = new long[n];
        for(int i = 0; i < s.length; i++) {
            board[i] = Long.parseLong(s[i]);
        }
        int left = 0;
        int right = n - 1;
        long max = 3_000_000_000L;
        long[] res = new long[2];
        while(left < right) {
//            System.out.println(left + " " + right);
            if(max > Math.abs(board[left] + board[right])) {
                res[0] = board[left];
                res[1] = board[right];
                max = Math.abs(board[left] + board[right]);
            }
            if(Math.abs(board[left]) <= Math.abs(board[right])) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(res[0] + " " + res[1]);
    }
}
