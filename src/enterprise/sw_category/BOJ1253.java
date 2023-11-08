package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        long[] board = new long[n];

        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);

        }
        Arrays.sort(board);
//        System.out.println(Arrays.toString(board));
        long cnt = 0;

        for(int i = 0; i < n; i++) {
            long target = board[i];
            int left = 0;
            int right = n - 1;
            while(left < right) {
                long sum = board[left] + board[right];
                if(sum > target) {
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    if(i == left) {
                        left++;
                    } else if(i == right) {
                        right--;
                    } else {
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
/**
 * -3 -2 1
 */
