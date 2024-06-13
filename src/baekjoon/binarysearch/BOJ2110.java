package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            int i1 = Integer.parseInt(br.readLine());
            houses[i] = i1;
        }
        Arrays.sort(houses);

        int low = 1;
        int high = houses[n - 1] - houses[0];
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canInstall(houses, n, c, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(res);
    }

    public static boolean canInstall(int[] houses, int n, int c, int mid) {
        int cnt = 1;
        int lastInstalled = houses[0];
        for(int i = 1; i < n; i++) {
            if(houses[i] - lastInstalled >= mid) {
                lastInstalled = houses[i];
                cnt++;
            }
        }
        return cnt >= c;
    }
}
