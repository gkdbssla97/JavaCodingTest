package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1244 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] board = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            board[i] = Integer.parseInt(s[i - 1]);
        }
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int sex = Integer.parseInt(s[0]);
            int num = Integer.parseInt(s[1]);
            if (sex == 1) { // 남자
                for (int j = num; j <= n; j += num) {
                    board[j] = 1 - board[j];
                }
            } else { // 여자
                int idx = 0;
                while (num - idx >= 1 && num + idx <= n) {
                    if (board[num - idx] == board[num + idx]) {
                        idx++;
                    } else {
                        break;
                    }
                }
                idx--;
                for (int j = num - idx; j <= num + idx; j++) {
                    board[j] = 1 - board[j];
                }
//                System.out.println(idx);
            }
        }
//        System.out.println(Arrays.toString(board));

        for (int i = 1; i <= n; i++) {
            System.out.print(board[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
