package programmers.summerwintercoding;

import java.util.Arrays;

public class 기지국설치 {
    static int[] board;
    static boolean[] visited;

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int parsing = (2 * w + 1);
        board = new int[n + 1];
        visited = new boolean[n + 1];
        visited[0] = true;

        int curr = 1, start = 1, end = 1, diff = 0;
        for (int station : stations) {
            start = station - w;
            end = station + w;
            if (curr >= start) {
                curr = end + 1;
            } else {
                diff = start - curr;
                if (diff % parsing == 0) {
                    answer += diff / parsing;
                } else answer += diff / parsing + 1;
                curr = end + 1;
            }
        }
        if (curr <= n) {
            diff = n - curr + 1;
            if (diff % parsing == 0) {
                answer += diff / parsing;
            } else answer += diff / parsing + 1;
        }
//        System.out.println(Arrays.toString(visited));

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int n = 16;
        int[] stations = {9};
        int w = 2;
        solution(n, stations, w);
    }
}
