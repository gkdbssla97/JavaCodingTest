package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] board = new int[n];

        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(s[i]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(board[0]);
        for(int i = 1; i < n; i++) {
            int v = board[i];
            if(arr.get(arr.size() - 1) < v) {
                arr.add(v);
            } else {
                int left = 0;
                int right = arr.size() - 1;

                while(left < right) {
                    int mid = (left + right) / 2;

                    if(arr.get(mid) < v) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                arr.set(right, board[i]);
            }
        }
        System.out.println(arr.size());
    }
}
