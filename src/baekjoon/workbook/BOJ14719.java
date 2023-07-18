package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14719 {
    static int[][] board;
    static int left, right;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);

        board = new int[h][w];
        int res = 0;
        String[] ss = br.readLine().split(" ");
        int[] height = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            height[i] = Integer.parseInt(ss[i]);
        }
        for(int i = 1; i < height.length - 1; i++) {
            //왼쪽 가장 높은거
            int _l = 0;
            for(int left = 0; left < i; left++) {
                _l = Math.max(height[left], _l);
            }
            //오른쪽 가장 높은거
            int _r = 0;
            for(int right = i + 1; right < height.length; right++) {
                _r = Math.max(height[right], _r);
            }

            int _res = Math.min(_l, _r);
            if(_res - height[i] > 0) {
                res += _res - height[i];
            }
//            System.out.println(_res - height[i]);
        }
        System.out.println(res);
    }
}
