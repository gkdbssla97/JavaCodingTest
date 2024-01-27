package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] len = br.readLine().split(" ");
        String[] cost = br.readLine().split(" ");

        long res = 0;
        res += Long.parseLong(len[0]) * Long.parseLong(cost[0]);

        long max = Long.parseLong(cost[0]);
        for(int i = 1; i < n - 1; i++) {
            if(max < Integer.parseInt(cost[i])) {
                res += Long.parseLong(len[i]) * max;
            } else {
                res += Long.parseLong(len[i]) * Long.parseLong(cost[i]);
                max = Integer.parseInt(cost[i]);
            }
        }
        System.out.println(res);
    }
}
