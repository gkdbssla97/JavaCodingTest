package syntax;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination {
    static boolean[] visited;
    static int[] arr = {1, 2, 3, 4, 5};
    static int[] selected;

    public static void main(String[] args) {

        int n = 5;

        selected = new int[3];
        visited = new boolean[n];

        combination(0, 0, 5, 3);

    }

    static void combination(int start, int cnt, int n, int r) {
        if (cnt == r) {
            System.out.println(Arrays.toString(selected));
            return;
        }
        for (int i = start; i < n; i++) {
            selected[cnt] = arr[i];
            combination(i + 1, cnt + 1, n, r);
        }
    }
}