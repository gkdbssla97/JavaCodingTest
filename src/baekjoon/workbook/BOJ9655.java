package baekjoon.workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9655 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

//        dfs(0);
        if(N % 2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

    static void dfs(int sum) {
        if(sum == N) {

        }
    }
}
