package baekjoon.workbook;

import java.util.*;
import java.io.*;
public class BOJ2512 {
    static int N, M;
    static int[] board;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        board = new int[N];

        int max = 0;
        for(int i = 0;i < s.length; i++) {
            board[i] = Integer.parseInt(s[i]);
            if(max <= board[i]) {
                max = board[i];
            }
        }

        M = Integer.parseInt(br.readLine());
        System.out.println(binarySearch(1, max));
    }
    static int binarySearch(int low, int high) {
        int res = 0;
        int res_mid = 0;
        while(low <= high) {
            int sum = 0;
            int mid = (low + high) / 2;
            for(int i = 0; i < board.length; i++) {
                if(board[i] < mid) {
                    sum += board[i];
                } else {
                    sum += mid;
                }
            }
            if(sum > M) {
                high = mid - 1;
            } else {
                low = mid + 1;
                if(res < sum) {
                    res_mid = mid;
                    res = sum;
                }
            }
        }
        return res_mid;
    }
}
