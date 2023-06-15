package baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1182 {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);

        String[] ss = br.readLine().split(" ");
        arr = new int[N];
        for(int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }

        int cnt = 0;
        int sum = 0;
        for(int i = 1; i < (1 << N); i++) {
            sum = 0;
            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) != 0) {
                    sum += arr[j];
//                    System.out.print(arr[j] + ", ");
                }
            }
            if(sum == S) {
//                System.out.println("i-> " + i);
                cnt++;
            }
//            System.out.println();
        }
        System.out.println(cnt);
    }
}
