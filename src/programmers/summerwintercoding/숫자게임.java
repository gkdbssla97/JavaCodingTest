package programmers.summerwintercoding;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 숫자게임 {
    static int answer = 0;
    static boolean[] visited;
    static int[] board;

    public static int solution(int[] A, int[] B) {
        visited = new boolean[B.length];
        board = new int[B.length];
        Arrays.sort(A);
        Arrays.sort(B);
        int i_a = 0, i_b = 0;
        while(i_b < B.length) {
            if (A[i_a] < B[i_b]) {
                i_a++;
                i_b++;
                answer++;
            }
            else i_b++;
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {900000000, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        solution(A, B);
    }
}
