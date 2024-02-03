package baekjoon.sweeping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2170 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            board[i][0] = Integer.parseInt(s[0]);
            board[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(board,
                (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } return o1[0] - o2[0];
                });

        int prevX = board[0][0];
        int prevY = board[0][1];
        int len = prevY - prevX;

        for(int i = 1; i < n; i++) {
            int curX = board[i][0];
            int curY = board[i][1];

            if(prevX <= curX && curY <= prevY) continue;
            if(curX < prevY) {
                len += curY - prevY;
            }
            if(curX > prevY) {
                len += curY - curX;
            }
            prevX = curX;
            prevY = curY;
        }
        System.out.println(len);
    }

}
