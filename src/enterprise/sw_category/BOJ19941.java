package enterprise.sw_category;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ19941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        s = br.readLine().split("");
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(s[i].equals("P")) {
//                System.out.println("i: " + i);
                // 왼쪽 ~ 오른쪽탐색
                for(int left = i - k; left <= i + k; left++) {
                    if(left == i || left < 0 || left >= n) continue;
                    if(s[left].equals("H") && !visited[left]) {
//                        System.out.println("l: " + left);
                        visited[left] = true;
                        break;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(visited));
        for(int i = 0; i < n; i++)
            if(visited[i]) {
                cnt++;
//                System.out.println(i + 1);
        }
        System.out.println(cnt);
    }
}
