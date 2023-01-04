package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ2331 {

    static int[] board;
    static boolean[] visited;
    static int count;
    static boolean findDuplicate(int val) {
        return visited[val];
    }

    static int calculate(int val, int P) {
        int total = 0;
        for (int i = val; i != 0; i /= 10) {
            int i1 = i % 10;
//            System.out.println("i1: " + i1);
            total += Math.pow(i1, P);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        board = new int[1000001];
        visited = new boolean[1000001];
        board[1] = A;
        visited[A] = true;
        count = 0;
        int idx = 1;
        int findRes = 0;
        while (true) {
            int result = calculate(board[idx], P);
//            System.out.println(result);
            board[++idx] = result;

            if(findDuplicate(result)) {
                for(int i = 1; i <= board.length; i++) {
                    if (board[i] == result) {
//                        System.out.println(i);
                        findRes = i;
                        break;
                    }
                }
                break;
            }
            visited[result] = true;
        }
        System.out.println(findRes - 1);
    }

}
