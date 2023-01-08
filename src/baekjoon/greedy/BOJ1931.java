package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1931 {
    static class Conf {
        int start;
        int end;

        public Conf(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static ArrayList<Conf> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>(N + 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Conf(a, b));
        }

        Collections.sort(arr, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        ArrayList<Conf> res = new ArrayList<>();
        res.add(arr.get(0));
        int cnt = 0;

        int start_time = 0;
        int end_time = 0;
        for (Conf d : arr) {
            if (d.start >= end_time) {
                end_time = d.end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
